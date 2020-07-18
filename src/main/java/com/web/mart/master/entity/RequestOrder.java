/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.master.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.mart.core.entity.MasterEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author regan
 */

@Entity
@Table(name = "tbl_request_order")
public class RequestOrder extends MasterEntity{
    
    @Column(name = "qty")
    private int qty;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private Unit unit;
    
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    
    @Column(name = "request_date", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;
    
    @Column(name = "delivery_date")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;    
    
//    @OneToMany(mappedBy = "order")
//    private List<RequestOrderDetail> details;
    
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

//    public List<RequestOrderDetail> getDetails() {
//        return details;
//    }
//
//    public void setDetails(List<RequestOrderDetail> details) {
//        this.details = details;
//    }
    
}
