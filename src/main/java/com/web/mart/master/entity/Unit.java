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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author regan
 */

@Entity
@Table(name = "tbl_units")
public class Unit extends MasterEntity{
    @Column(name = "description")
    private String desc;
    @Column(name = "code")
    private String code;
    
    @OneToMany(mappedBy = "unit")
    @JsonIgnore
    private List<RequestOrder> requestOrders;
    
    @OneToMany(mappedBy = "unit")
    @JsonIgnore
    private List<Stock> stocks;
    
    @OneToMany(mappedBy = "unit")
    @JsonIgnore
    private List<OrderDetail> orderDetails;
    
    public Unit() {
    }

    public Unit(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<RequestOrder> getRequestOrders() {
        return requestOrders;
    }

    public void setRequestOrders(List<RequestOrder> requestOrders) {
        this.requestOrders = requestOrders;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

      
}
