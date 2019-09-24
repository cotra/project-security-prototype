package pw.cotra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pw.cotra.security.point.AppAuthenticationEntryPoint;
import pw.cotra.security.service.AppUserDetailsService;

@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AppAuthenticationEntryPoint appAuthenticationEntryPoint () {
        return new AppAuthenticationEntryPoint();
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
        http.authorizeRequests().antMatchers("/role/**").permitAll().antMatchers("/user/**").hasRole("USER").anyRequest().authenticated().and().formLogin();
    }
}
