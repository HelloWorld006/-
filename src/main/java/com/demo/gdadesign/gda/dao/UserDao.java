package com.demo.gdadesign.gda.dao;

import com.demo.gdadesign.gda.entity.UserEntity;
import com.demo.gdadesign.gda.repository.UserRepository;
import com.demo.gdadesign.gda.shard.SharedData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    /**
     * 根据用户名查找
     * @param username
     * @return
     */
    public List<UserEntity> findByUserName(String username) {
        UserRepository userRepository = SharedData.getSharedData().getUserRepository();
        List<UserEntity> byUsername = userRepository.findByUsername(username);
        return byUsername;
    }

    /**
     * 根据账号密码查找
     * @param username
     * @param password
     * @return
     */
    public UserEntity findByUsernameAndPassword(String username,String password) {
        UserRepository userRepository = SharedData.getSharedData().getUserRepository();
        UserEntity byUsername = userRepository.findByUsernameAndPassword(username,password);
        return byUsername;
    }
}
