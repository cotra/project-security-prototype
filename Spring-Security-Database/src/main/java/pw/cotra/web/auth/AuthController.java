package pw.cotra.web.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pw.cotra.core.api.Api;
import pw.cotra.core.api.Letter;
import pw.cotra.core.cstp.Cstp;
import pw.cotra.web.auth.dto.LoginReq;
import pw.cotra.web.auth.dto.LoginRes;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("auth/login")
    public Api<LoginRes> login(@RequestBody @Validated LoginReq req) {
        Cstp<LoginRes> cstp = authService.login(req);
        if (cstp.isOk()) {
            return Letter.ok("登录成功", cstp.getData());
        } else {
            return Letter.fail(cstp.getReason(), null);
        }
    }
}
