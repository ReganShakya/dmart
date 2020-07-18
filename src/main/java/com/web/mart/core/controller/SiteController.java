/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.core.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author regan
 */
public class SiteController {
    protected String pageTitle;
    protected String activeMenu;
    protected String pageURI;
    
    @ModelAttribute
    public void globalVariables(Model model){
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("activeMenu", activeMenu);
        model.addAttribute("pageURI", pageURI);
    }

    public SiteController() {
    }
    
    public SiteController(String pageTitle){
        this.pageTitle=pageTitle;
    }
    
    public SiteController(String pageTitle, String activeMenu){
        this.pageTitle = pageTitle;
        this.activeMenu = activeMenu;
    }

    public SiteController(String pageTitle, String activeMenu, String pageURI) {
        this.pageTitle = pageTitle;
        this.activeMenu = activeMenu;
        this.pageURI = pageURI;
    }
    
    
}
