package pw.cotra.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pw.cotra.po.SysPermission;
import pw.cotra.po.SysRole;

import java.util.List;

public interface PubAuthDao {

    @Select("SELECT r.name FROM ums_admin_role_relation ar INNER JOIN ums_role r ON ar.role_id = r.id WHERE ar.admin_id=#{id}")
    List<SysRole> getRoleList(@Param("id") Long id);

    @Select("SELECT p.id,p.name,p.value FROM ums_admin a INNER JOIN ums_admin_role_relation ar ON a.id=ar.admin_id INNER JOIN ums_role r ON ar.role_id=r.id INNER JOIN ums_role_permission_relation rp ON r.id=rp.role_id INNER JOIN ums_permission p ON rp.permission_id=p.id WHERE a.id=#{id} GROUP BY p.id;")
    List<SysPermission> getPermissionList(@Param("id") Long id);
}
