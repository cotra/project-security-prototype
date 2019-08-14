package pw.cotra.web.role;

import cn.hutool.core.bean.BeanUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pw.cotra.core.api.Api;
import pw.cotra.core.api.Letter;
import pw.cotra.core.cstp.Cstp;
import pw.cotra.dto.PageList;
import pw.cotra.po.SysRole;
import pw.cotra.web.WebApiUrl;
import pw.cotra.web.role.dto.RoleListReq;

@RestController
@RequestMapping(value = WebApiUrl.ROLE)
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("list")
    public Api<PageList<SysRole>> list(@RequestBody @Validated RoleListReq req) {
        SysRole role = new SysRole();
        BeanUtil.copyProperties(req, role);
        Cstp<PageList<SysRole>> cstp = roleService.getPageList(req.getSize(), req.getPage(), role);
        if(cstp.isOk()) {
            return Letter.ok(cstp.getData());
        }
        return Letter.fail();
    }

    @GetMapping("add")
    public Api<String> add() {
        return Letter.ok();
    }
}
