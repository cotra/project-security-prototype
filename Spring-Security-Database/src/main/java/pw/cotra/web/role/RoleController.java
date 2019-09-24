package pw.cotra.web.role;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pw.cotra.core.api.Api;
import pw.cotra.core.api.Letter;

@RestController
@RequestMapping("/role")
public class RoleController {

    @RequestMapping("list")
//    @PreAuthorize("hasAnyAuthority('ROLE_LOOK', 'LOOK')")
    public Api<String> list() {
        return Letter.ok("role list123123");
    }
}
