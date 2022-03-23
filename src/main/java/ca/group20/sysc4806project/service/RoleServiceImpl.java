package ca.group20.sysc4806project.service;

import ca.group20.sysc4806project.model.Role;
import ca.group20.sysc4806project.repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService, CommandLineRunner {

    private final RoleRepo roleRepo;

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void run(String... args) {
        saveRole(new Role("ROLE_SURVEYOR"));
        saveRole(new Role("ROLE_ADMIN"));
    }
}
