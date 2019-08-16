package pw.cotra.web.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthBoTest {

    @Autowired
    AuthBo authBo;
    @Test
    public void encode() {
        String encode = authBo.encode("123456");
        System.out.println(encode);
    }

    @Test
    public void match() {
    }
}