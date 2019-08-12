package pw.cotra.web.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pw.cotra.core.api.Api;
import pw.cotra.core.api.Letter;
import pw.cotra.web.WebApiUrl;

@RestController
@RequestMapping(value = WebApiUrl.USER)
public class UserController {

    @GetMapping("add")
    public Api<String> add() {
        return Letter.ok();
    }
}
