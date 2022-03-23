package ca.group20.sysc4806project.service;

import ca.group20.sysc4806project.exception.InvalidRoleException;
import ca.group20.sysc4806project.exception.SurveyorAlreadyExistsException;
import ca.group20.sysc4806project.model.Role;
import ca.group20.sysc4806project.model.Surveyor;
import ca.group20.sysc4806project.repository.RoleRepo;
import ca.group20.sysc4806project.repository.SurveyorRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Use to connect to Surveyor Database
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SurveyorServiceImpl implements SurveyorService, UserDetailsService {

    private final SurveyorRepo surveyorRepo;
    private final RoleRepo roleRepo;

    @Autowired
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Adds a new surveyor to the database
     *
     * @param surveyor surveyor to be added
     * @return new surveyor
     */
    @Override
    public Surveyor saveSurveyor(Surveyor surveyor) throws SurveyorAlreadyExistsException, InvalidRoleException {
        if (checkIfUsernameExists(surveyor.getUsername())) {
            throw new SurveyorAlreadyExistsException("surveyor already exists");
        }
        surveyor.setHashedPassword(passwordEncoder().encode(surveyor.getHashedPassword()));
        Surveyor newSurveyor = surveyorRepo.save(surveyor);
        log.info(surveyor.getUsername() + " has been saved");
        addRoleToSurveyor(surveyor.getUsername(), "ROLE_SURVEYOR");
        return newSurveyor;
    }

    @Override
    public boolean checkIfUsernameExists(String username) {
        return surveyorRepo.findByUsername(username) != null;
    }

    @Override
    public void addRoleToSurveyor(String username, String roleName) throws UsernameNotFoundException, InvalidRoleException {
        Surveyor surveyor = surveyorRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        if (surveyor != null && role != null) {
            surveyor.addRole(role);
            log.info(role.getName() + " has been added to " + surveyor.getUsername());
        } else if (surveyor == null) {
            throw new UsernameNotFoundException("Surveyor not found with username: " + username);
        } else {
            throw new InvalidRoleException("Invalid Role name: " + roleName + " Valid Role names: ROLE_SURVEYOR OR ROLE_ADMIN");
        }
    }

    /**
     * get surveyor from the database based off the username given
     *
     * @param surveyorUsername a surveyor's user name
     * @return surveyor table from the database
     */
    @Override
    public Surveyor getSurveyor(String surveyorUsername) {
        log.info("Fetching Surveyor " + surveyorUsername);
        return surveyorRepo.findByUsername(surveyorUsername);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Surveyor surveyor = surveyorRepo.findByUsername(username);
        if (surveyor == null) {
            throw new UsernameNotFoundException("Surveyor not found with username: " + username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        surveyor.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(surveyor.getUsername(), surveyor.getHashedPassword(), authorities);
    }
}
