/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.master.controller;

import com.web.mart.core.controller.CRUDController;
import com.web.mart.master.entity.Product;
import com.web.mart.master.entity.Supplier;
import com.web.mart.master.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author regan
 */
@Controller
@RequestMapping(value = "/suppliers")
public class SupplierController extends CRUDController<Supplier, Integer>{

    public SupplierController() {
        super("Supplier","master","suppliers");
        this.viewPath = "suppliers";
    }
    
    @Autowired
    private ProductRepository productRepository;
    
    @GetMapping
    public String index(Model model){
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("records", repository.findAll());
        return viewPath+"/index";
    }
    
//    @GetMapping(value = "/infoTable")
//    public String table(Model model){
//        model.addAttribute("records", repository.findAll());
//        return "suppliers/components/infoTable";
//    }
    
    @Override
    public String create(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return super.create(model);
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id")Integer id, Model model){
        model.addAttribute("products",
                productRepository.findAll());
        model.addAttribute("record",
                repository.findById(id).get());
        return "suppliers/edit";
    }
    
    
    
    @GetMapping(value = "/info/{id}")
    public String info(@PathVariable("id")Integer id, Model model){
        model.addAttribute("records",
                productRepository.findBySupplierId(id));
        model.addAttribute("record",
                productRepository.countBySupplierId(id));
        return "suppliers/info";
    }
    
    @GetMapping(value = "/products/{productId}")
    @ResponseBody
    public List<Product> products(@PathVariable("productId")int productId){
        return repository
                .findById(productId).get()
                .getProducts();
    }
}
