package pw.cotra.security;

import org.apache.shiro.web.servlet.AdviceFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ShiroAdviceFilter extends AdviceFilter {

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("ShiroAdviceFilter");
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        SysUser sysUser = (SysUser) httpServletRequest.getSession().getAttribute("user");
//        if (null == sysUser && !StringUtils.contains(httpServletRequest.getRequestURI(), "/login")) {
//
//            ResponseHeader responseHeader = new ResponseHeader();
//            responseHeader.setResponse(ResponseHeader.SC_MOVED_TEMPORARILY, null);
//            httpServletResponse.setCharacterEncoding("UTF-8");
//            httpServletResponse.setContentType("application/json");
//            httpServletResponse.getWriter().write(JSONObject.toJSONString(responseHeader));
//            return false;
//        }
        return false;
    }
}
