/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.master.repository;

import com.web.mart.master.entity.Stock;
import com.web.mart.master.entity.StockByProduct;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author regan
 */

public interface StockRepository extends 
        JpaRepository<Stock, Integer>{
    
//    @Query("SELECT u.product.name, SUM(u.quantity)"
//            + " FROM Stock u GROUP BY u.product.name")
//    List<Stock> getStockByProductName();
    
    @Query("SELECT new com.web.mart.master.entity.StockByProduct(u.product.name,  SUM(u.quantity))"
            + " FROM Stock u GROUP BY u.product.name")
    List<StockByProduct> getStockByProductName();
    
}
