package pw.cotra.web.role;

import org.springframework.web.bind.annotation.*;
import pw.cotra.core.api.Api;
import pw.cotra.core.api.Letter;

@RestController
@RequestMapping("/role")
public class RoleController {

    @RequestMapping("list")
    public Api<String> list() {
        return Letter.ok("role list");
    }
}
