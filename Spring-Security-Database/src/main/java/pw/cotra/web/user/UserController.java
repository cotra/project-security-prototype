package pw.cotra.web.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;
import pw.cotra.core.api.Api;
import pw.cotra.core.api.Letter;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("list")
    public Api<String> list() {
        return Letter.ok("user list");
    }
}
