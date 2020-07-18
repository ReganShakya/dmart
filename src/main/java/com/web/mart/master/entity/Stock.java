/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.master.entity;

import com.web.mart.core.entity.MasterEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author regan
 */

@Entity
@Table(name = "tbl_stock")
public class Stock extends MasterEntity{
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "rate")
    private int rate;
        
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    
    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private Unit unit;
    
    @Column(name = "created_date", insertable = false, updatable = false)
    private String createdDate;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }    

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }    
    
}
