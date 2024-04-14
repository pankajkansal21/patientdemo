package com.app.patientInfo.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class BaseAction extends ActionSupport {

    public boolean isValidUser() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();

        String s = (String) session.getAttribute("login");
        if (s != null && !s.equals("")) {
            return true;
        }

        return false;
    }
}
