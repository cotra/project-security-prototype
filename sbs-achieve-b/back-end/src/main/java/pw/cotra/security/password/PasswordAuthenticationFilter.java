package pw.cotra.security.password;

import cn.hutool.Hutool;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pw.cotra.web.WebApiUrl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class PasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public PasswordAuthenticationFilter() {
        super(new AntPathRequestMatcher(WebApiUrl.LOGIN_PASSWORD, "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException, IOException, ServletException {
        String body = ServletUtil.getBody(req);
        PasswordReq passwordReq = JSONUtil.parseObj(body).toBean(PasswordReq.class);
        String username = passwordReq.getUsername();
        log.info(username + "正在进行登录" + req.getSession().getId());
        String password = passwordReq.getPassword();
        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        username = username.trim();
        password = password.trim();

        PasswordAuthenticationToken authRequest = new PasswordAuthenticationToken(username, password);
        this.setDetails(req, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }
}
