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
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author regan
 */

@Entity
@Table(name = "tbl_supplier")
public class Supplier extends MasterEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;    
    @Column(name = "contact_no")
    private String contactNo;
    
    @OneToMany
    @JoinTable(
        name = "tbl_products",
            joinColumns = {@JoinColumn(name = "supplier_id")},
            inverseJoinColumns = {@JoinColumn(name = "id")}
    )
    private List<Product> products;
    
    @OneToMany(mappedBy = "supplier")
    @JsonIgnore
    private List<Order> orders;

    public Supplier() {
    }

    public Supplier(String name, String address, String email, String contactNo) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
 
    
}
