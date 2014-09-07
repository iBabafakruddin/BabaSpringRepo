package com.baba.demo.utils;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserSecurityValidation implements UserDetailsService
{

    @Override
    public UserDetails loadUserByUsername(String userId)
    {
        UserDetails user = null;
        Collection<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
        String pass = "";
        try
        {
            if(userId != null && userId.equalsIgnoreCase("baba"))
            {
                GrantedAuthority userGrantedAuthority = new SimpleGrantedAuthority ("ROLE_USER");
                GrantedAuthority adminGrantedAuthority = new SimpleGrantedAuthority ("ROLE_ADMIN");
                authority.add(userGrantedAuthority);
                authority.add(adminGrantedAuthority);
                user = new LoginUserDetails(userId, pass, true, authority);
            }
/*            Object userObj= null; // this is user model class userDao.findUserById();
            SecurityContextHolder.getContext().getAuthentication();
            if (userObj!= null)
            {
                
                pass =  "user password"; //userObj.getPassword();

                GrantedAuthority adminGrantedAuthority = new SimpleGrantedAuthority ("ROLE_ADMIN");
                GrantedAuthority tsmGrantedAuthority = new SimpleGrantedAuthority ("ROLE_TSM");
                GrantedAuthority rsmGrantedAuthority = new SimpleGrantedAuthority ("ROLE_RSM");

                if ("userObj.getType()".equalsIgnoreCase("ADMIN"))
                {

                    authority.add(adminGrantedAuthority);
                }
                else if ("userObj.getType()".equalsIgnoreCase("USER"))
                {
                    authority.add(tsmGrantedAuthority);
                }

            }*/
            if (user == null)
            {
                throw new UsernameNotFoundException("Invalid username and passowrd");
            }
        }
        catch (Exception e)
        {
            System.out.println("User not found");
            throw new UsernameNotFoundException(e.getLocalizedMessage(), e);
        }

        return user;
    }

    
}

