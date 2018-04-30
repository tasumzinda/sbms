/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.totalit.sbms.utilities.StringUtils;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Roy
 */
@Entity
@Table(name = "category")
public class Category extends BaseName{
    private static final long serialVersionUID = 1L;
    @Transient
    private String printName;
    @OneToMany(mappedBy = "category")
    private Set<Brand> brand = new HashSet<>();

    public Category() {
    }

    public Category(String name, String description) {
        super(name, description);
    }
    
    public Set<Brand> getBrand() {
        return brand;
    }

    public void setBrand(Set<Brand> brand) {
        this.brand = brand;
    }
    
    public String getPrintName(){
        return StringUtils.toCamelCase3(super.getName());
    }
}
