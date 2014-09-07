package com.baba.demo.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Intercipt all requests and filter them
 * @author baba
 *
 */
public class LoginFilter implements Filter
{
    
    private int customSessionExpiredErrorCode = 901;

    @Override
    public void destroy()
    {
    }

    @Override
    public void doFilter(ServletRequest httpReq, ServletResponse httpResp, FilterChain arg2) throws IOException, ServletException
    {

        String ajaxHeader = ((HttpServletRequest) httpReq).getHeader("X-Requested-With");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        String userName=httpReq.getParameter("j_username");
        String password=httpReq.getParameter("j_password");

        String requestURI = ((HttpServletRequest) httpReq).getRequestURI();

        if (!requestURI.contains("/login")
                && (authentication != null && authentication.getAuthorities().contains(new GrantedAuthorityImpl("ROLE_ANONYMOUS")))
                && ("XMLHttpRequest".equals(ajaxHeader)))
        {
            HttpServletResponse resp = (HttpServletResponse) httpResp;
            resp.sendError(this.customSessionExpiredErrorCode);

        }
        else
        {
            arg2.doFilter(httpReq, httpResp);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException
    {
    }


}
