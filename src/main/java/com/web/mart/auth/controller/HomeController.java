/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.auth.controller;

import com.web.mart.master.repository.OrderDetailRepository;
import com.web.mart.master.repository.ProductRepository;
import com.web.mart.master.repository.StockRepository;
import com.web.mart.master.repository.SupplierRepository;
import com.web.mart.master.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author regan
 */

@Controller
@RequestMapping
public class HomeController {
    
    @Autowired
    private SupplierRepository supplierRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UnitRepository unitRepository;
    
    @Autowired
    private StockRepository stockRepository;
    
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    
    @GetMapping(value = {"/","/index"})
    public String index(){
        return "index";
    }
    
    @GetMapping(value = "/dashBoard")
    public String dashBoard(Model model){
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("units", unitRepository.findAll());
        model.addAttribute("stocks", stockRepository.getStockByProductName());
        model.addAttribute("orderDetails", orderDetailRepository.findAll());
        return "dashBoard";
    }
}
