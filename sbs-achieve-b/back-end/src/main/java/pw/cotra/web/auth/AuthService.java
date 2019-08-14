package pw.cotra.web.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pw.cotra.core.cstp.Cstp;
import pw.cotra.core.cstp.Result;
import pw.cotra.service.SysUserService;
import pw.cotra.web.auth.dto.LoginReq;
import pw.cotra.web.auth.dto.LoginRes;

@Service
public class AuthService {

    @Autowired
    SysUserService sysUserService;

    // 账户已经登录
    public static String ACCOUNT_ONLINE = "ACCOUNT_ONLINE";
    // 账户验证失败
    public static String ACCOUNT_FAIL = "ACCOUNT_FAIL";
    // 账户被锁定
    public static String ACCOUNT_LOCKED = "ACCOUNT_LOCKED";

    // 登录
    public Cstp<LoginRes> login(LoginReq req) {
//        Subject subject = SecurityUtils.getSubject();
//        if(subject.isAuthenticated()) {
//            return Result.fail(ACCOUNT_ONLINE);
//        }
//
//        try {
//            subject.login(new UsernamePasswordToken(req.getUsername(), AuthBo.passwordToMd5Hash(req.getKey())));
//            return Result.ok();
//        } catch (UnknownAccountException e) {
//            return Result.fail(ACCOUNT_FAIL);
//        } catch (IncorrectCredentialsException e) {
            return Result.fail(ACCOUNT_FAIL);
//        }
    }
}
