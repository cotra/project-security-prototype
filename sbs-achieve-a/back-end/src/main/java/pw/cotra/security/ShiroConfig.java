package pw.cotra.security;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pw.cotra.core.cstp.Cstp;
import pw.cotra.po.SysUser;
import pw.cotra.web.WebApiUrl;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;

@Configuration
public class ShiroConfig {

    @Autowired
    ShiroRealmService service;
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager());

        // 添加Filter
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("authFilter", new ShiroFormAuthenticationFilter());
        factoryBean.setFilters(filterMap);

        Map<String, String> filterRuleMap = new HashMap<>();
        // 配置路径
        filterRuleMap.put("/**", "authFilter");
        filterRuleMap.put(WebApiUrl.AUTH + "/**", "anon");

        Cstp<SysUser> admin = service.getAdmin("admin");
        factoryBean.setFilterChainDefinitionMap(filterRuleMap);
        return factoryBean;
    }

    // 实现的realm
    @Bean
    public ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }

    // 授权管理器
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(shiroRealm());
        return manager;
    }
}
