package com.demo.gdadesign.gda.controller;

import com.demo.gdadesign.gda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

}
