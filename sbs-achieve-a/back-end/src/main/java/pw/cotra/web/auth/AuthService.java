package pw.cotra.web.auth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pw.cotra.core.cstp.Cstp;
import pw.cotra.core.cstp.Result;
import pw.cotra.po.SysUser;
import pw.cotra.service.SysUserService;
import pw.cotra.web.auth.dto.LoginReq;
import pw.cotra.web.auth.dto.LoginRes;

@Service
public class AuthService {

    @Autowired
    SysUserService sysUserService;

    // 注册

    // 账户验证失败
    public static String ACCOUNT_FAIL = "ACCOUNT_FAIL";
    // 账户被锁定
    public static String ACCOUNT_LOCKED = "ACCOUNT_LOCKED";

    // 登录
    public Cstp<LoginRes> login(LoginReq req) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", req.getUsername());
        SysUser sysUser = sysUserService.getOne(wrapper);
        System.out.println(sysUser);

        if(sysUser == null) {
            return Result.fail(ACCOUNT_FAIL);
        }
//        if(!authBo.match(req.getKey(), sysUser.getPassword())) {
//            return Result.fail(ACCOUNT_FAIL);
//        }
//        if(umsAdmin.getStatus() == 0) {
//            return Result.fail(ACCOUNT_LOCKED);
//        }

//        // 验证通过,修改用户登录时间,用该时间生成jwt
//        Date lastLoginDate = new Date();
//        int result = authDao.updateLoginTime(umsAdmin.getId(), lastLoginDate);
//        if(result != 1) {
//            return Result.fail(ACCOUNT_FAIL);
//        }
//        UmsAdmin admin = umsAdminDao.selectById(umsAdmin.getId());
//
//        // 返回认证token
//        String jwt = jwtTokenBo.generate(umsAdmin.getId(), umsAdmin.getUsername(), lastLoginDate);
//
//        LoginRes res = new LoginRes();
//        BeanUtil.copyProperties(admin, res);
//        res.setToken(jwt);
//        return Result.ok(res);
        return null;
    }
}
