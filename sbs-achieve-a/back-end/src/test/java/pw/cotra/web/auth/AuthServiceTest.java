package pw.cotra.web.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pw.cotra.core.cstp.Cstp;
import pw.cotra.web.auth.dto.LoginReq;
import pw.cotra.web.auth.dto.LoginRes;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthServiceTest {

    @Autowired
    AuthService service;
    @Test
    public void login() {
        LoginReq req = new LoginReq();
        Cstp<LoginRes> login = service.login(req);
        System.out.println(login);
    }
}