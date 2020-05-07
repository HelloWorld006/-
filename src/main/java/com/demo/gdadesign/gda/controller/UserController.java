package com.demo.gdadesign.gda.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.gdadesign.gda.service.UserService;
import com.demo.gdadesign.gda.untils.PubUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("login")
    public JSONObject login(String username, String password) {
        String msg = userService.userLogin(username, password);
        if ("success".equals(msg)) {
            return PubUtils.getReturnData(msg, 200, null);
        } else {
            return PubUtils.getReturnData(msg, 500, null);
        }
    }
}
