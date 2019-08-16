package pw.cotra.security.handler;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import pw.cotra.core.api.Api;
import pw.cotra.core.api.Letter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class AppAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override

    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication authentication) throws IOException, ServletException {
        log.warn("AccessDeniedHandler: " + authentication.getPrincipal() + authentication.getCredentials());

        Api<Object> api = Letter.fail("登录成功", null);
        JSON parse = JSONUtil.parse(api);

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(parse.toString());
        res.getWriter().flush();
    }
}
