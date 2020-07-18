/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.master.controller;

import com.web.mart.core.controller.CRUDController;
import com.web.mart.master.entity.Order;
import com.web.mart.master.entity.OrderDetail;
import com.web.mart.master.repository.OrderDetailRepository;
import com.web.mart.master.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.web.mart.master.repository.SupplierRepository;
import com.web.mart.master.repository.UnitRepository;
import javax.transaction.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author regan
 */
@Controller
@RequestMapping(value = "/orders")
public class OrderController extends 
        CRUDController<Order, Integer>{
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private SupplierRepository supplierRepository;
    
    @Autowired
    private UnitRepository unitRepository;
    
    @Autowired
    private OrderDetailRepository detailRepository;

    public OrderController() {
        super("Order","master","orders");
        this.viewPath = "orders";
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
        model.addAttribute("units",unitRepository.findAll());        
        model.addAttribute("suppliers",supplierRepository.findAll());
        return super.create(model);
    }
    
    @Override
    public String edit(@PathVariable("id") Integer id, Model model){
        model.addAttribute("products",productRepository.findAll());
        model.addAttribute("units",unitRepository.findAll());
        return super.edit(id, model);
    }

    @Transactional
    @ResponseBody
    @Override
    public String saveJson(Order entity) {
//       repository.saveAll(entity.getOrderDetails());
           repository.save(entity);
        for(OrderDetail detail:entity.getOrderDetails()){
            detail.setOrder(entity);
            detailRepository.saveAndFlush(detail);
        }
        
     
        
        return entity.getId() +"";
        //return super.saveJson(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
