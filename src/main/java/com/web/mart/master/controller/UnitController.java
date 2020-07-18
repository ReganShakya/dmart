/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.master.controller;

import com.web.mart.core.controller.CRUDController;
import com.web.mart.master.entity.Unit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author regan
 */
@Controller
@RequestMapping(value = "/units")
public class UnitController extends CRUDController<Unit, Integer>{

    public UnitController() {
        super("Unit","master","units");
        this.viewPath = "units";
    }
}
