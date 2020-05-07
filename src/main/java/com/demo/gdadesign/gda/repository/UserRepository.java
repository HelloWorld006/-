package com.demo.gdadesign.gda.repository;

import com.demo.gdadesign.gda.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    List<UserEntity> findByUsername(String username);

    UserEntity findByUsernameAndPassword(String username,String password);
}
