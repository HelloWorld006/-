package com.demo.gdadesign.gda.service.impl;

import com.demo.gdadesign.gda.dao.UserDao;
import com.demo.gdadesign.gda.entity.UserEntity;
import com.demo.gdadesign.gda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String userLogin(String username, String password) {
        if (StringUtils.isEmpty(username)) {
            return "请输入账号";
        } else {
            List<UserEntity> byUserName = userDao.findByUserName(username);
            if (byUserName.size() == 0 || byUserName == null) {
                return "账号不存在 ";
            } else {
                UserEntity byUsernameAndPassword = userDao.findByUsernameAndPassword(username, password);
                if (byUsernameAndPassword == null) {
                    return "密码不正确";
                } else {
                    //登陆成功
                    return "success";
                }
            }
        }

    }
}
