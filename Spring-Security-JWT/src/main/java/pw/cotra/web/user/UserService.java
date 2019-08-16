package pw.cotra.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pw.cotra.core.cstp.Cstp;
import pw.cotra.core.cstp.Result;
import pw.cotra.po.SysUser;
import pw.cotra.service.SysUserService;

@Service
public class UserService {

    @Autowired
    SysUserService sysUserService;

    public Cstp<String> add(SysUser user) {
        boolean save = sysUserService.save(user);
        if(save) {
            return Result.ok();
        }
        return Result.fail();
    }
}
