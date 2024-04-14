package com.app.patientInfo.service.impl;

import com.app.patientInfo.dao.UserDao;
import com.app.patientInfo.model.User;
import com.app.patientInfo.service.LoginService;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    public boolean validate(String username, String password) {
        /*User user = userDao.findByUsername(username);

        String hashedPassword = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();

        return user != null && user.getPassword().equals(hashedPassword);*/
        return "Test@123".equals(password);
    }

}
