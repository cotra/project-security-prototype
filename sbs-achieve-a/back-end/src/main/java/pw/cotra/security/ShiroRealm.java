package pw.cotra.security;

import cn.hutool.Hutool;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import pw.cotra.core.cstp.Cstp;
import pw.cotra.po.SysUser;

import java.util.Set;

@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    ShiroRealmService service;

    /**
     * 重写realm名称
     */
    @Override
    public String getName() {
        return "appShiroRealm";
    }

    /**
     * 支持类型,现在支持UsernamePasswordToken类型的Token
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        log.warn("授权访问验证");
//        UmsAdminAuth user = (UmsAdminAuth) getAvailablePrincipal(principal);
//        Cstp<Set<String>> roles = service.getAdminRoles(user.getId());
//        Cstp<Set<String>> perms = service.getAdminPerms(user.getId());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        if(roles.isOk()) {
//            info.setRoles(roles.getData());
//        }
//        if(perms.isOk()) {
//            info.setStringPermissions(perms.getData());
//        }

        return info;
    }

    /**
     * 认证
     * principal：身份 / credentials：证明
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.warn("doGetAuthenticationInfo");
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String guestName = upToken.getUsername(); //访客用户名

        Cstp<SysUser> cstp = service.getAdmin(guestName); // 根据访客用户名查找用户
        if(!cstp.isOk()) {
            throw new UnknownAccountException(); // 账户错误
        }
        SysUser user = cstp.getData();

        // 返回对照用户名和对照MD5
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}