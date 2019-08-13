package pw.cotra.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pw.cotra.core.cstp.Cstp;
import pw.cotra.core.cstp.Result;
import pw.cotra.po.SysUser;
import pw.cotra.service.SysUserService;

import java.util.Set;

@Service
public class ShiroRealmService {

    @Autowired
    SysUserService sysUserService;

    // 获得管理员
    public Cstp<SysUser> getAdmin(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        SysUser sysUser = sysUserService.getOne(wrapper);
        if(sysUser == null) {
            return Result.fail();
        }
        return Result.ok(sysUser);
    }

    // 获得管理员角色列表
    public Cstp<Set<String>> getAdminRoles(Long id) {
        System.out.println("getAdminRoles");
//        List<UmsRole> list = authDao.getRoleList(id);
//        HashSet<String> hashSet = new HashSet<>();
//        list.forEach(item -> hashSet.add(item.getName()));
//
//        return Result.ok(hashSet);
        return null;
    }

    // 获得管理员权限列表
    public Cstp<Set<String>> getAdminPerms(Long id) {
        System.out.println("getAdminPerms");
//        List<UmsPermission> list = authDao.getPermissionList(id);
//        HashSet<String> hashSet = new HashSet<>();
//        list.forEach(item -> hashSet.add(item.getValue()));
//
//        return Result.ok(hashSet);
        return null;
    }
}
