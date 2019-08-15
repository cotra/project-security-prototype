package pw.cotra.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pw.cotra.core.cstp.Result;
import pw.cotra.po.SysUser;
import pw.cotra.service.SysUserService;

@Slf4j
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        System.out.println("-----------------");
        System.out.println(name);
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", name);
        SysUser sysUser = sysUserService.getOne(wrapper);
        if (sysUser == null) {
            throw new UsernameNotFoundException("User was not found in db");
        }

        AppUserDetails details = new AppUserDetails(sysUser.getUsername(), "{noop}" + sysUser.getPassword());
        return details;
    }
}