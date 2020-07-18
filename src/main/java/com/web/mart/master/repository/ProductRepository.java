/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.master.repository;

import com.web.mart.master.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author regan
 */

public interface ProductRepository extends 
        JpaRepository<Product, Integer>{
    List<Product> findBySupplierId(int id);
    
    @Query("select count(e) from Product e where e.supplierId = ?1")
    int countBySupplierId(int supplierId);

}
