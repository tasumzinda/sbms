/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.domain;

import com.totalit.sbms.utilities.StringUtils;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Roy
 */
@Entity
@Table(name = "branch")
public class Branch extends BaseName{
    private static final long serialVersionUID = 1L;
    @Transient
    private String printName;
    private String address;
    @ManyToOne
    private Client client;
    @Transient
    private Long ci;
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getCi() {
        return ci;
    }

    public void setCi(Long ci) {
        this.ci = ci;
    }
    
   
     
    public String getPrintName(){
        return StringUtils.toCamelCase3(super.getName());
    }
}
