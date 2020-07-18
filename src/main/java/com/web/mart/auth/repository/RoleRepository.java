/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.auth.repository;

import com.web.mart.auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author regan
 */
public interface RoleRepository extends 
        JpaRepository<Role, Integer>{
    
}
