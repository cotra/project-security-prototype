package pw.cotra.web.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pw.cotra.po.SysUser;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService service;

    @Test
    public void add() {
        SysUser user = new SysUser();
        user.setUsername("admin");
        user.setPassword("123456");
        service.add(user);
        System.out.println(user.getId());
    }
}