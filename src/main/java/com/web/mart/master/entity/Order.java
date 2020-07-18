/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.master.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.mart.core.entity.MasterEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author regan
 */

@Entity
@Table(name = "tbl_orders")
public class Order extends MasterEntity{
    @Column(name = "ordered_date",insertable = false, updatable = false)
    private LocalDateTime orderedDate =LocalDateTime.now();
    
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;
    
    @OneToMany(targetEntity = OrderDetail.class,mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderDetail> orderDetails;
    
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//        name = "tbl_order_details",
//            joinColumns = {@JoinColumn(name = "order_id")},
//            inverseJoinColumns = {@JoinColumn(name = "id")}
//    )
//    private List<OrderDetail> orderDetails= new ArrayList<>();
    
    public Order() {
    }

    public LocalDateTime getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(LocalDateTime orderedDate) {
        this.orderedDate = orderedDate;
    }


    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
    
        
}
