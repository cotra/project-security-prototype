package pw.cotra.web.auth;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pw.cotra.core.api.Api;
import pw.cotra.core.api.Letter;
import pw.cotra.web.auth.dto.LoginReq;
import pw.cotra.web.auth.dto.LoginRes;

@RestController
public class AuthController {

    @PostMapping("login")
    public Api<LoginRes> login(@RequestBody @Validated LoginReq req) {
//        Cstp<LoginRes> cstp = service.login(req);
//        if(cstp.isOk()) {
//            return Letter.ok("登录成功", cstp.getData());
//        } else if(cstp.getFlag().equals(service.ACCOUNT_FAIL)) {
//            return Letter.fail("账号或密码错误", null);
//        } else if(cstp.getFlag().equals(service.ACCOUNT_LOCKED)) {
//            return Letter.fail("该账号已被锁定,请联系系统管理人员", null);
//        } else {
            return Letter.fail("登录失败", null);
//        }
    }
}
