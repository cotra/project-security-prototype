package pw.cotra.security.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Slf4j
public class AppUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        log.info("Arrivals Request Token: " + token);
        return null;
    }
}