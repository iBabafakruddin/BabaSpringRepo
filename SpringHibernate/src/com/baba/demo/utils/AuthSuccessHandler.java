package com.baba.demo.utils;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.web.servlet.LocaleResolver;


public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler
{

    @Autowired
    private LocaleResolver localeResolver;
    

    @Autowired
    @Qualifier("authenticationManager")
    protected AuthenticationManager authenticationManager;

    
   // Logger logger = Logger.getLogger(this.getClass().getName());

    /*
     * (non-Javadoc)
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException
    {

        String userId = request.getParameter("j_username");
        String password = request.getParameter("j_password");
        request.getRequestURI();
        HttpSession session = request.getSession(false);
        if(session!=null)
        {
            Object userVoObj = null;
            try
            {
                userVoObj = new Object();//userDelegator.findById(userId);
            }
            catch (Exception e)
            {
                System.out.println("Error while reading User record"+e);
            }

            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);
            session.setAttribute("user", userId);
            try
            {
                
                localeResolver.setLocale(request, response,Locale.US);
            }
            catch (Exception e)
            {
            	System.out.println("Error while setting the Locale"+ e);
            }
        }
        super.onAuthenticationSuccess(request, response, authentication);

    }

}

