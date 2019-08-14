package pw.cotra.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pw.cotra.security.filter.TokenAuthenticationFilter;
import pw.cotra.security.handler.AppAccessDeniedHandler;
import pw.cotra.security.point.AppAuthenticationEntryPoint;
import pw.cotra.security.provider.AppAuthenticationProvider;
import pw.cotra.security.service.AppUserDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public static Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Bean
    AppUserDetailsService appUserDetailsService() {
        return new AppUserDetailsService();
    };

    @Bean
    TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter();
    }

    @Bean
    AppAccessDeniedHandler appAccessDeniedHandler() {
        return new AppAccessDeniedHandler();
    }

    @Bean
    AppAuthenticationEntryPoint appAuthenticationEntryPoint() {
        return new AppAuthenticationEntryPoint();
    }

    @Bean
    AppAuthenticationProvider appAuthenticationProvider() {
        return new AppAuthenticationProvider();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
//        builder.authenticationProvider(appAuthenticationProvider());
    builder.userDetailsService(appUserDetailsService());
    }

    //请求拦截
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 不使用csrf/表单登录
        HttpSecurity security = http.csrf().disable().formLogin().disable().logout().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().headers().cacheControl().disable().and();
        // filter
        HttpSecurity custom = security.addFilterAt(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        // 自定义
        HttpSecurity role = custom.exceptionHandling().authenticationEntryPoint(appAuthenticationEntryPoint()).accessDeniedHandler(appAccessDeniedHandler()).and();
        // 规则
//        role.authorizeRequests().antMatchers(UmsApiUrl.AUTH + "/**").permitAll().antMatchers(UmsApiUrl.ROLE + "/**", PmsApiUrl.BRAND + "/**").authenticated();
    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }
}
