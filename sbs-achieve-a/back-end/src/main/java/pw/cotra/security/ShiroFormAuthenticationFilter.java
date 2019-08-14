package pw.cotra.security;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import pw.cotra.core.api.Api;
import pw.cotra.core.api.Letter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest req, ServletResponse res) throws IOException {
        Api<Object> api = Letter.fail("用户尚未登录", null);
        JSON parse = JSONUtil.parse(api);

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(parse.toString());
        res.getWriter().flush();
        return false;
    }
}
