/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.domain;

import com.totalit.sbms.domain.util.ClientType;
import com.totalit.sbms.domain.util.YesNo;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Roy
 */
@Entity
@Table(name = "client")
public class Client extends BaseEntity{
    private static final long serialVersionUID = 1L;
 
    private String clientType;
    private String name;
    private String description;
    private String website;
    private String address;
    private String email;
    private String phone;
  
    private String branchesYesNo;
    @OneToMany(mappedBy = "client")
    private Set<Branch> branch = new HashSet<>();
   
    @OneToOne(mappedBy = "client")
    private RequiredDocuments requiredDocuments;
    
   
    @OneToMany(mappedBy = "client")
    private Set<Contact> contact = new HashSet<>();
    @OneToMany(mappedBy = "client")
    private Set<ClientInventory> clientInventorys = new HashSet<>();

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Branch> getBranch() {
        return branch;
    }

    public void setBranch(Set<Branch> branch) {
        this.branch = branch;
    }

   
    public Set<Contact> getContact() {
        return contact;
    }

    public void setContact(Set<Contact> contact) {
        this.contact = contact;
    }

    public String getBranchesYesNo() {
        return branchesYesNo;
    }

    public void setBranchesYesNo(String branchesYesNo) {
        this.branchesYesNo = branchesYesNo;
    }

    public RequiredDocuments getRequiredDocuments() {
        return requiredDocuments;
    }

    public void setRequiredDocuments(RequiredDocuments requiredDocuments) {
        this.requiredDocuments = requiredDocuments;
    }

    public Set<ClientInventory> getClientInventorys() {
        return clientInventorys;
    }

    public void setClientInventorys(Set<ClientInventory> clientInventorys) {
        this.clientInventorys = clientInventorys;
    }

    
}
