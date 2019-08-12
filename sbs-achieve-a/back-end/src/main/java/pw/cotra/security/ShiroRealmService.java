package pw.cotra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pw.cotra.core.cstp.Cstp;
import pw.cotra.core.cstp.Result;
import pw.cotra.po.SysUser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ShiroRealmService {

    // 获得管理员
    public Cstp<SysUser> getAdmin(String username) {

//        List<UmsAdminAuth> list = umsAdminDao.getList(username);
//        if(list.size() == 0 || list.size() != 1) {
//            return Result.fail();
//        }
//        return Result.ok(list.get(0));
        return null;
    }

    // 获得管理员角色列表
    public Cstp<Set<String>> getAdminRoles(Long id) {
//        List<UmsRole> list = authDao.getRoleList(id);
//        HashSet<String> hashSet = new HashSet<>();
//        list.forEach(item -> hashSet.add(item.getName()));
//
//        return Result.ok(hashSet);
        return null;
    }

    // 获得管理员权限列表
    public Cstp<Set<String>> getAdminPerms(Long id) {
//        List<UmsPermission> list = authDao.getPermissionList(id);
//        HashSet<String> hashSet = new HashSet<>();
//        list.forEach(item -> hashSet.add(item.getValue()));
//
//        return Result.ok(hashSet);
        return null;
    }
}
