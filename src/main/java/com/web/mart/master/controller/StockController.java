 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.master.controller;

import com.web.mart.core.controller.CRUDController;
import com.web.mart.master.entity.Stock;
import com.web.mart.master.entity.StockByProduct;
import com.web.mart.master.repository.ProductRepository;
import com.web.mart.master.repository.StockRepository;
import com.web.mart.master.repository.SupplierRepository;
import com.web.mart.master.repository.UnitRepository;
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
@RequestMapping(value = "/stocks")
public class StockController extends 
        CRUDController<Stock, Integer>{
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UnitRepository unitRepository;
    
    @Autowired
    private SupplierRepository supplierRepository;
    
    @Autowired
    private StockRepository stockRepository;

    public StockController() {
        super("Stock","master","stocks");
        this.viewPath = "stocks";
    }

    @Override
    public String index(Model model) {
        model.addAttribute("suppliers", supplierRepository.findAll());        
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("units", unitRepository.findAll());
        model.addAttribute("stocks", stockRepository.getStockByProductName());
        return super.index(model); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public String create(Model model) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("units", unitRepository.findAll());
        return super.create(model); //To change body of generated methods, choose Tools | Templates.
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id")Integer id, Model model){
        model.addAttribute("record",
                repository.findById(id).get());
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("units", unitRepository.findAll());
        return "stocks/edit";
    }
    
    @GetMapping(value = "/distinct")
    @ResponseBody
    public List<StockByProduct> distinct(){
        return stockRepository.getStockByProductName();
    }
    
    
}
