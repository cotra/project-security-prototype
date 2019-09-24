package pw.cotra.web.permission;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pw.cotra.core.api.Api;
import pw.cotra.core.api.Letter;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @RequestMapping("list")
    public Api<String> list() {
        return Letter.ok("permission list");
    }
}
