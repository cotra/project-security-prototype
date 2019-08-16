package pw.cotra.web.role;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pw.cotra.core.cstp.Cstp;
import pw.cotra.core.cstp.Result;
import pw.cotra.dto.PageList;
import pw.cotra.dto.PlusPage;
import pw.cotra.po.SysRole;
import pw.cotra.service.SysRoleService;

@Service
public class RoleService {
    @Autowired
    SysRoleService sysRoleService;

    public Cstp<PageList<SysRole>> getPageList(Long size, Long page, SysRole role) {
        // 条件
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        if(StrUtil.isNotBlank(role.getRoleName())) {
            wrapper.like("role_name", role.getRoleName());
        }
        // 执行
        IPage<SysRole> list = sysRoleService.page(new PlusPage<>(size, page), wrapper);
        // 结果
        PageList<SysRole> resPageList = new PageList<>(list.getRecords(), list.getTotal(), list.getSize(), list.getCurrent());
        // 返回
        return Result.ok(resPageList);
    }
}
