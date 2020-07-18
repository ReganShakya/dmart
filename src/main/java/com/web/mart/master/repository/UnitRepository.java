/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.master.repository;

import com.web.mart.master.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author regan
 */

public interface UnitRepository extends 
        JpaRepository<Unit, Integer>{
    
}
