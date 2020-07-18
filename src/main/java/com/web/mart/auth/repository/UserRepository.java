/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.auth.repository;

import com.web.mart.auth.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author regan
 */
public interface UserRepository extends 
        JpaRepository<User, Integer>{
    
    User findByUserName(String username);
    User findByEmail(String email);
    List<User> findByRoleId(int roleId);
}
