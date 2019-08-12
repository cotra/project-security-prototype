package pw.cotra.web.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pw.cotra.core.cstp.Cstp;
import pw.cotra.dao.SysUserDao;
import pw.cotra.web.auth.dto.LoginReq;
import pw.cotra.web.auth.dto.LoginRes;

@Service
public class AuthService {

    @Autowired
    SysUserDao sysUserDao;

    // 账户验证失败
    public static String ACCOUNT_FAIL = "ACCOUNT_FAIL";
    // 账户被锁定
    public static String ACCOUNT_LOCKED = "ACCOUNT_LOCKED";

    // 登录
    public Cstp<LoginRes> login(LoginReq req) {
//        List<UmsAdmin> list = authDao.getListByName(req.getUsername());
//        if(list.size() == 0 || list == null) {
//            return Result.fail(ACCOUNT_FAIL);
//        }
//        if(list.size() != 1) {
//            return Result.fail(ACCOUNT_FAIL);
//        }
//        UmsAdmin umsAdmin = list.get(0);
//        if(umsAdmin.getStatus() == 0) {
//            return Result.fail(ACCOUNT_LOCKED);
//        }
//        if(!authBo.match(req.getKey(), umsAdmin.getPassword())) {
//            return Result.fail(ACCOUNT_FAIL);
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
