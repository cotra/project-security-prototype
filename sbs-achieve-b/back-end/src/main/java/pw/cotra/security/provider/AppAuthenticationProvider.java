package pw.cotra.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import pw.cotra.security.service.AppUserDetailsService;

public class AppAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    AppUserDetailsService appUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String id = (String) authentication.getPrincipal();
        UserDetails userDetails = appUserDetailsService.loadUserByUsername(id);
//        System.out.println(authentication.getCredentials());
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
