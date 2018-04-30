/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.controller;

import com.totalit.sbms.domain.Client;
import com.totalit.sbms.domain.Contact;
import com.totalit.sbms.service.ContactService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("client/contact")
public class ContactController {
     
    @Resource
    private ContactService contactService;
    
    private String setUpModel(ModelMap model, Contact item) {
         
         model.addAttribute("pageTitle", "Add/View Contacts");
         model.addAttribute("contactsForm", item);
         
              
          return "master";
      }
     @RequestMapping(value = "/addContact", method = RequestMethod.GET)
     public String addContacts(ModelMap model, @RequestParam Long id){
         Contact con =  new Contact();
         model.addAttribute("clickContacts", true); 
         model.addAttribute("ci", id);
         model.addAttribute("contacts", contactService.findByClientId(id));
         return setUpModel(model, con);
     }
}
