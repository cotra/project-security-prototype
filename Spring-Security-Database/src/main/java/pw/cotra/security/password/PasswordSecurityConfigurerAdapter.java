package pw.cotra.security.password;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class PasswordSecurityConfigurerAdapter extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        PasswordAuthenticationFilter passwordAuthenticationFilter = new PasswordAuthenticationFilter();
        passwordAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        PasswordAuthenticationProvider passwordAuthenticationProvider = new PasswordAuthenticationProvider();
        http.authenticationProvider(passwordAuthenticationProvider)
                .addFilterAfter(passwordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
