package pw.cotra.security.password;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import pw.cotra.security.service.AppUserDetailsService;

public class PasswordAuthenticationProvider implements AuthenticationProvider {

    private AppUserDetailsService userDetailsService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        PasswordAuthenticationToken authenticationToken = (PasswordAuthenticationToken) authentication;

        String username = (String) authenticationToken.getPrincipal();
        System.out.println(username);
        UsernamePasswordAuthenticationToken authenticationResult = new UsernamePasswordAuthenticationToken("admin","123");

        authenticationResult.setDetails(authenticationToken.getDetails());

        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        System.out.println("support");
        boolean flag = PasswordAuthenticationToken.class.isAssignableFrom(aClass);
        return true;
    }

    public void setUserDetailsService(AppUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
