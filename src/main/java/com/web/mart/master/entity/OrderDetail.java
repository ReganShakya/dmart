/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.master.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.mart.core.entity.MasterEntity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author regan
 */

@Entity
@Table(name = "tbl_order_details")
public class OrderDetail extends MasterEntity{
    
    @Column(name = "quantity")
    private int quantity;
    
    @Column(name = "price",insertable = false)
    private int price;    
    
//    @ManyToOne
//    @JoinTable(name = "tbl_orders",
//            joinColumns = { @JoinColumn(name = "id")},
//            inverseJoinColumns = { @JoinColumn(name = "order_id")}
//    )
//    private Order order;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY) 
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @JsonIgnore
    private Order order;
    
    
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;    
    
    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private Unit unit;
        


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
}
