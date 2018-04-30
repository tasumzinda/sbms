/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.dto;

import com.totalit.sbms.domain.Brand;
import com.totalit.sbms.domain.Client;
import com.totalit.sbms.domain.ClientInventory;
import java.io.Serializable;

/**
 *
 * @author user
 */
public class ClientInventoryDTO implements Serializable{
    
    private String model;
    private int quantity;
    private String needMaintenence;
    private Brand brands; 
    private Client client;
    private Long ci;
    private Long brand;

    public ClientInventoryDTO() {
    }

    public ClientInventoryDTO(String model, int quantity, String needMaintenence, Brand brands, Client client) {
        this.model = model;
        this.quantity = quantity;
        this.needMaintenence = needMaintenence;
        this.brands = brands;
        this.client = client;
    }

    public ClientInventoryDTO(String model, int quantity, String needMaintenence) {
        this.model = model;
        this.quantity = quantity;
        this.needMaintenence = needMaintenence;
    }
    
    

    

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNeedMaintenence() {
        return needMaintenence;
    }

    public void setNeedMaintenence(String needMaintenence) {
        this.needMaintenence = needMaintenence;
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

    public Brand getBrands() {
        return brands;
    }

    public void setBrands(Brand brands) {
        this.brands = brands;
    }

    public Long getBrand() {
        return brand;
    }

    public void setBrand(Long brand) {
        this.brand = brand;
    }
    public ClientInventory getInstance(ClientInventoryDTO clientInventoryDTO){
        ClientInventory ci = new ClientInventory(model, quantity, needMaintenence, brands, client, brand);
        return ci;
    }
   
    
}
