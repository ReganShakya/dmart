/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.mart.core.entity.MasterEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author regan
 */
@Entity
@Table(name = "mst_roles")
public class Role extends MasterEntity {

    @Column(name = "role_name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<User> users;

    public Role() {

    }

    public Role(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
