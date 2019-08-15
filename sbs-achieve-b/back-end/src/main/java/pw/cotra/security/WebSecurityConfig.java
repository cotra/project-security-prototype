package pw.cotra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pw.cotra.security.password.PasswordSecurityConfigurerAdapter;
import pw.cotra.security.handler.AppAccessDeniedHandler;
import pw.cotra.security.point.AppAuthenticationEntryPoint;
import pw.cotra.web.WebApiUrl;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    AppAccessDeniedHandler appAccessDeniedHandler() {
        return new AppAccessDeniedHandler();
    }

    @Bean
    AppAuthenticationEntryPoint appAuthenticationEntryPoint() {
        return new AppAuthenticationEntryPoint();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
//        builder.userDetailsService(appUserDetailsService());
//    }

    //请求拦截
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 不使用csrf/默认表单登录/默认basic登录
        HttpSecurity security = http.apply(new PasswordSecurityConfigurerAdapter()).and().csrf().disable().formLogin().disable().logout().disable().httpBasic().disable();
        // 自定义
        HttpSecurity role = security.exceptionHandling().authenticationEntryPoint(appAuthenticationEntryPoint()).accessDeniedHandler(appAccessDeniedHandler()).and();
        // 规则
        role.authorizeRequests().antMatchers(WebApiUrl.AUTH + "/**").permitAll().antMatchers(WebApiUrl.ROLE + "/**", WebApiUrl.ROLE + "/**").authenticated();
    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }
}
