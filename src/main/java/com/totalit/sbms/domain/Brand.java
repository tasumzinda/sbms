/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.domain;

import com.totalit.sbms.utilities.StringUtils;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "brand")

public class Brand extends BaseName{
    private static final long serialVersionUID = 1L;
    @Transient
    private String printName;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "brand")
    private Set<ClientInventory> clientInventorys = new HashSet<>();

    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<ClientInventory> getClientInventorys() {
        return clientInventorys;
    }

    public void setClientInventorys(Set<ClientInventory> clientInventorys) {
        this.clientInventorys = clientInventorys;
    }
    
    
    public String getPrintName() {
        return StringUtils.toCamelCase3(super.getName());
    }
    
}
