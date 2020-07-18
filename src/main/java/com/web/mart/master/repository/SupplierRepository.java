/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.master.repository;

import com.web.mart.master.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author regan
 */

public interface SupplierRepository extends 
        JpaRepository<Supplier, Integer>{
        @Query(value = "select count(e) from tbl_supplier_product e where e.supplier_d = ?1", nativeQuery = true)
        int countBySupplierId(int id);
}
