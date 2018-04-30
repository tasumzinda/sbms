/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.dto;

import com.totalit.sbms.domain.Client;
import com.totalit.sbms.domain.Contact;
import java.io.Serializable;

/**
 *
 * @author user
 */
public class ContactDTO implements Serializable{
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String jobPosition;
    private String department;
    private String officePhone;
    private String mobilePhone;
    private String email;
    private Client client;
    private Long ci;

    public ContactDTO() {
    }
    

    public ContactDTO(Long id, String firstName, String lastName, String gender, String jobPosition, String department, String officePhone, String mobilePhone, String email, Client client) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.jobPosition = jobPosition;
        this.department = department;
        this.officePhone = officePhone;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    public  Contact getInstance(ContactDTO cdto){
        Contact c = new Contact(firstName, lastName, gender, jobPosition, department, officePhone, mobilePhone, email, client, Long.MIN_VALUE);
        return c;
    }
    
    
}
