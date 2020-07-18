/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.auth.service;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author regan
 */
public class AuthUser extends User{
    
    public AuthUser(String username, String password, Collection<?
            extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
    
}
