package pw.cotra.security.password;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class PasswordAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        PasswordAuthenticationToken authenticationToken = (PasswordAuthenticationToken) authentication;

        String username = (String) authenticationToken.getPrincipal();
        System.out.println(username);

        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        boolean flag = PasswordAuthenticationToken.class.isAssignableFrom(aClass);
        return flag;
    }
}
