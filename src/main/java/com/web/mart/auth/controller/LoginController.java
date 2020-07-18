/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.auth.controller;

import com.web.mart.core.controller.SiteController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author regan
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends SiteController{

    public LoginController() {
        super("Login");
    }
    
    
    @GetMapping
    public String index(Model model){
        return "login";
    }
    
     // Login form with error
    @RequestMapping("login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
    
//    @GetMapping(value = "/logout")
//    public String logout(HttpSession session){
//        session.invalidate();
//        return "redirect:login";
//    }
}
