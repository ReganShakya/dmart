/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.auth.controller;

import com.web.mart.auth.entity.Role;
import com.web.mart.core.controller.CRUDController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author regan
 */
@Controller
@RequestMapping(value="/roles")
public class RoleController extends CRUDController<Role, Integer>{

    public RoleController() {
        super("Role","auth","roles");
        this.viewPath="roles";
    }
}
