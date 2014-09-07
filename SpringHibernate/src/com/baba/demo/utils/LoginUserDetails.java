package com.baba.demo.utils;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUserDetails implements UserDetails
{
    private String screenMsg;

    private String screenMsgType;

    private String userName;

    private String password;

    private Collection<GrantedAuthority> authorities;

    private Boolean enabled;

    private Boolean credentialsNonExpired;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    public LoginUserDetails(String userId, String pass, boolean enabled, Collection<GrantedAuthority> authority)
    {
        setUserName(userId);
        setPassword(pass);
        setEnabled(enabled);
        setAuthorities(authority);
    }

    public LoginUserDetails()
    {
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the screenMsg
     */
    public String getScreenMsg()
    {
        return screenMsg;
    }

    /**
     * @param screenMsg the screenMsg to set
     */
    public void setScreenMsg(String screenMsg)
    {
        this.screenMsg = screenMsg;
    }

    /**
     * @return the userName
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * @param authorities the authorities to set
     */
    public void setAuthorities(Collection<GrantedAuthority> authorities)
    {
        this.authorities = authorities;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(Boolean enabled)
    {
        this.enabled = enabled;
    }

    /**
     * @param credentialsNonExpired the credentialsNonExpired to set
     */
    public void setCredentialsNonExpired(Boolean credentialsNonExpired)
    {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    /**
     * @param accountNonExpired the accountNonExpired to set
     */
    public void setAccountNonExpired(Boolean accountNonExpired)
    {
        this.accountNonExpired = accountNonExpired;
    }

    /**
     * @param accountNonLocked the accountNonLocked to set
     */
    public void setAccountNonLocked(Boolean accountNonLocked)
    {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities()
    {
        return authorities;
    }

    @Override
    public String getUsername()
    {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return enabled;
    }

    public void setScreenMsgType(String screenMsgType)
    {
        this.screenMsgType = screenMsgType;
    }

    public String getScreenMsgType()
    {
        return screenMsgType;
    }
}
