/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.master.controller;

import com.web.mart.core.controller.CRUDController;
import com.web.mart.master.entity.OrderDetail;
import com.web.mart.master.repository.OrderRepository;
import com.web.mart.master.repository.ProductRepository;
import com.web.mart.master.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.web.mart.master.repository.SupplierRepository;

/**
 *
 * @author regan
 */
@Controller
@RequestMapping(value = "/orderDetails")
public class OrderDetailsController extends 
        CRUDController<OrderDetail, Integer>{
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private SupplierRepository supplierRepository;
    
    @Autowired
    private UnitRepository unitRepository;
    
    @Autowired
    private OrderRepository orderRepository;

    public OrderDetailsController() {
        super("OrderDetail","master","orderDetails");
        this.viewPath = "orderDetails";
    }

    @Override
    public String index(Model model) {       
        model.addAttribute("suppliers",supplierRepository.findAll());      
        model.addAttribute("products",productRepository.findAll());
        model.addAttribute("units",unitRepository.findAll());
        return super.index(model); //To change body of generated methods, choose Tools | Templates.
    }    
    
    @Override
    public String create(Model model){
        model.addAttribute("products",productRepository.findAll());
//        model.addAttribute("productsByVendorId",productRepository.findByVendorId(0));
        model.addAttribute("units",unitRepository.findAll());
        model.addAttribute("orders",orderRepository.findAll());        
        model.addAttribute("suppliers",supplierRepository.findAll());
        return super.create(model);
    }
    
    @Override
    public String edit(@PathVariable("id") Integer id, Model model){
        model.addAttribute("products",productRepository.findAll());
        model.addAttribute("units",unitRepository.findAll());
        model.addAttribute("orders",orderRepository.findAll());
        return super.edit(id, model);
    }
    
    @GetMapping(value = "/orders")
    public String orders(Model model){
        model.addAttribute("records",repository.findAll());        
        model.addAttribute("products",productRepository.findAll());
        model.addAttribute("units",unitRepository.findAll());
        return "orderDetails/orders";
    }
    
    
    
}
