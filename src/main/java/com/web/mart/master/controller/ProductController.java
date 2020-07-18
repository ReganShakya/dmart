 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.master.controller;

import com.web.mart.core.controller.CRUDController;
import com.web.mart.master.entity.Product;
import com.web.mart.master.repository.OrderDetailRepository;
import com.web.mart.master.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.web.mart.master.repository.SupplierRepository;

/**
 *
 * @author regan
 */
@Controller
@RequestMapping(value = "/products")
public class ProductController extends 
        CRUDController<Product, Integer>{
    
    @Autowired
    private ProductRepository repository;
    
    @Autowired
    private SupplierRepository supplierRepository;
    
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public ProductController() {
        super("Product","master","products");
        this.viewPath = "products";
    }
    
    @Override
    public String index(Model model){
        model.addAttribute("records", repository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        return viewPath+"/index";
    }
    
    @Override
    public String create(Model model){
        model.addAttribute("records", repository.findAll());
        model.addAttribute("suppliers",supplierRepository.findAll());
        return super.create(model);
    }
    
    @Override
    public String edit(@PathVariable("id") Integer id, Model model){
        model.addAttribute("suppliers", supplierRepository.findAll());
        return super.edit(id, model);
    }
    
    @GetMapping(value = "/suppliers/{supplierId}")
    @ResponseBody
    public List<Product> getSupplierProducts(@PathVariable("supplierId")int supplierId){
        return repository.findBySupplierId(supplierId);
    }
}
