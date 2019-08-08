package pw.cotra.bootstrap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pw.cotra.core.api.Api;
import pw.cotra.core.api.Letter;

@RestController
public class IndexController {

    @RequestMapping("/")
    public Api<String> index() {
        return Letter.ok("sbs-achieve-a service is running.");
    }
}
