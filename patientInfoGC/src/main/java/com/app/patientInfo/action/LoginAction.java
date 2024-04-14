package com.app.patientInfo.action;

import com.app.patientInfo.service.impl.LoginServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {

    private String username;
    private String userpass;
    private SessionMap<String,String> sessionmap;

    @Autowired
    private LoginServiceImpl loginService;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String show() {
        sessionmap.invalidate();
        return SUCCESS;
    }

    public String execute(){
        if(loginService.validate(username, userpass)){
            return SUCCESS;
        }
        else{
            sessionmap.invalidate();
            addActionError("Invalid username and password.");
            return INPUT;
        }
    }

    public void setSession(Map map) {
        sessionmap=(SessionMap)map;
        sessionmap.put("login","true");
    }

    public String logout(){
        sessionmap.invalidate();
        return SUCCESS;
    }

}