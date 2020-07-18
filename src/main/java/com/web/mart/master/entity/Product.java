/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.master.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.mart.core.entity.MasterEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author regan
 */

@Entity
@Table(name = "tbl_products")
public class Product extends MasterEntity{
    @Column(name = "status")
    private boolean status;
        
    @ManyToOne 
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @JsonIgnore
    private Supplier supplier;
    
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<RequestOrder> requestOrders;
    
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Stock> stocks;
    
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<OrderDetail> orderdetails;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "supplier_id", insertable = false, updatable = false)
    private int supplierId;
    
    public Product() {}

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RequestOrder> getRequestOrders() {
        return requestOrders;
    }

    public void setRequestOrders(List<RequestOrder> requestOrders) {
        this.requestOrders = requestOrders;
    }

    public List<OrderDetail> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(List<OrderDetail> orderdetails) {
        this.orderdetails = orderdetails;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
    
    
    
    
    
}
