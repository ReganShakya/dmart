///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.web.mart.master.controller;
//
//import com.web.mart.core.controller.CRUDController;
//import com.web.mart.master.entity.RequestOrderDetail;
//import com.web.mart.master.repository.CustomerRepository;
//import com.web.mart.master.repository.ProductRepository;
//import com.web.mart.master.repository.UnitRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// *
// * @author regan
// */
//@Controller
//@RequestMapping(value = "/requestOrders")
//public class RequestOrderDetailController extends 
//        CRUDController<RequestOrderDetail, Integer>{
//    
//    @Autowired
//    private ProductRepository productRepository;
//    
//    @Autowired
//    private UnitRepository unitRepository;
//    
//    @Autowired
//    private CustomerRepository customerRepository;
//    
//    public RequestOrderDetailController() {
//        super("RequestOrder","master","requestOrders");
//        this.viewPath = "requestOrders";
//    }
//    
//    @Override
//    public String create(Model model){
//        model.addAttribute("products",productRepository.findAll());
//        model.addAttribute("units",unitRepository.findAll());
//        model.addAttribute("customers",customerRepository.findAll());
//        return super.create(model);
//    }
//    
//    @Override
//    public String edit(@PathVariable("id") Integer id, Model model){
//        model.addAttribute("products",productRepository.findAll());
//        model.addAttribute("units",unitRepository.findAll());
//        model.addAttribute("customers",customerRepository.findAll());
//        return super.edit(id, model);
//    }
//}
