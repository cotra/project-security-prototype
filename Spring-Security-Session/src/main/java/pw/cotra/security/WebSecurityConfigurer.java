package pw.cotra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pw.cotra.security.password.PasswordAuthenticationFilter;
import pw.cotra.security.password.PasswordAuthenticationProvider;
import pw.cotra.security.service.AppUserDetailsService;
import pw.cotra.web.WebApiUrl;

@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AppUserDetailsService appUserDetailsService() {
        return new AppUserDetailsService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        HttpSecurity security = http.csrf().disable().httpBasic().disable().formLogin().disable();

        PasswordAuthenticationFilter passwordAuthenticationFilter = new PasswordAuthenticationFilter();
        passwordAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        PasswordAuthenticationProvider passwordAuthenticationProvider = new PasswordAuthenticationProvider();
        passwordAuthenticationProvider.setUserDetailsService(appUserDetailsService());

        HttpSecurity setting = security.authenticationProvider(passwordAuthenticationProvider).addFilterAfter(passwordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        //
        setting.authorizeRequests().antMatchers(WebApiUrl.LOGIN_PASSWORD).permitAll().antMatchers("/user/**").authenticated().antMatchers("/role/**").authenticated();
    }
}
