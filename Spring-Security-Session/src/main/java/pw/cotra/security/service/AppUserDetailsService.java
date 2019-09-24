package pw.cotra.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pw.cotra.po.SysRole;
import pw.cotra.po.SysUser;
import pw.cotra.security.dto.AppUserDetails;
import pw.cotra.service.SysRoleService;
import pw.cotra.service.SysUserService;

@Slf4j
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysRoleService sysRoleService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        System.out.println(name + " loadUserByUsername");
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", name);
        SysUser sysUser = sysUserService.getOne(wrapper);
        System.out.println(sysUser);
        if (sysUser == null) {
            throw new BadCredentialsException("User was not found in db");
        }

        AppUserDetails details = new AppUserDetails(sysUser.getUsername(), sysUser.getPassword());
        return details;
    }
}