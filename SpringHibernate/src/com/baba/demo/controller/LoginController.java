package com.baba.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author baba
 * This is Spring Controller component (To be develop).
 * 
 */
@Controller
public class LoginController
{

    @RequestMapping(value={"/login"},method=RequestMethod.GET)
   public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session,
           @RequestParam(value = "check", required = false) String action)
   {
       ModelAndView mav = new ModelAndView("login");
       
       BadCredentialsException w_springMessage = null;
       if(session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION") instanceof  BadCredentialsException)
       {
           w_springMessage = (BadCredentialsException) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION"); 
       }
       if ("logout".equalsIgnoreCase(action))
       {
           if (!session.isNew())
           {
             session.invalidate();
           }
           mav.addObject("screenMsg", "You have been logged out of the system");
           mav.addObject("screenMsgType", "logout");
       }
       if(w_springMessage != null)
       {
           if (!session.isNew())
           {
               session.invalidate();
           }
           mav.addObject("screenMsg","The information you entered does not match our records.<br />Please verify your information.");
           mav.addObject("screenMsgType", "invalidCredentials");
       }
       return mav;
   }
    
    @RequestMapping(value={"/","/home"},method=RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {
        ModelAndView mav = new ModelAndView("home");
        
        return mav;
        
    }
    

}
