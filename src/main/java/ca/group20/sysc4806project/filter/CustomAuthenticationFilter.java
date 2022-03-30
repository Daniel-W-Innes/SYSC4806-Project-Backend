package ca.group20.sysc4806project.filter;

import ca.group20.sysc4806project.utility.TokenUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try (BufferedReader reader = request.getReader()) {

            /* JSON transformation */
            JsonObject obj = Json.createReader(reader).readObject();
            String username = obj.getString(getUsernameParameter());
            String password = obj.getString(getPasswordParameter());

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    username, password);

            return authenticationManager.authenticate(authToken);
        } catch (IOException ex) {
            throw new AuthenticationServiceException("Parsing JSON Request failed", ex);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        User user = (User) authResult.getPrincipal();
        Map<String, String> tokens = new HashMap<>();
        TokenUtility.createAccessToken(user.getUsername(), user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()), tokens);
        TokenUtility.createRefreshToken(user.getUsername(), tokens);
        response.setContentType("application/json");
        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        response.setHeader("error", failed.getMessage());
        response.setStatus(UNAUTHORIZED.value());
        Map<String, String> error = new HashMap<>();
        error.put("error", "The username or password you entered is incorrect");
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), error);
    }

}
