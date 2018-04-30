/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.controller;

import com.totalit.sbms.domain.Client;
import com.totalit.sbms.domain.util.ClientType;
import com.totalit.sbms.domain.util.YesNo;
import com.totalit.sbms.service.ClientService;
import com.totalit.sbms.utilities.AppMessage;
import com.totalit.sbms.utilities.MessageType;
import com.totalit.sbms.validator.ClientValidator;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Roy
 */
@Controller
@RequestMapping("/client")
public class ClientController {
    
    @Resource
    private ClientService clientService;
    @Resource
    private ClientValidator clientValidator;
     
    
   
     private String setUpModel(ModelMap model, Client item) {
         
         model.addAttribute("pageTitle", "Create/Edit Client");
         model.addAttribute("item", item);
         model.addAttribute("clientType", ClientType.values());
         model.addAttribute("yesNo", YesNo.values());
              
          return "master";
      }
     @RequestMapping("/addClient")
     public String addUsers(ModelMap model){
         Client client =  new Client();
         model.addAttribute("clickAddClient", true); 
         return setUpModel(model, client);
     }
     @RequestMapping("/list")
     public String listClient(ModelMap model){
         model.addAttribute("pageTitle", "List Client");
         model.addAttribute("clickListClient", true);
         model.addAttribute("clients", clientService.getAll());
         return "master";
     }
    @RequestMapping(value = "/addClient/form", method = RequestMethod.GET)
    public String userForm(ModelMap model, @RequestParam(required = false) Long id) {
        
       model.addAttribute("message", new AppMessage.MessageBuilder().build());
       model.addAttribute("clickAddClient", true); 
        Client c = new Client();
        if (id != null) {
            c = clientService.get(id);
        }
        return setUpModel(model, c);
    }
    
    
    
    @RequestMapping(value = "/addClient/form", method = RequestMethod.POST)
    public String saveUsers(@ModelAttribute("item") @Valid Client client, BindingResult result, ModelMap model, RedirectAttributes redirectAttrs){  
        
        clientValidator.validate(client, result);     
        if (result.hasErrors()) {  
        model.addAttribute("clickAddClient", true); 
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());           
        return setUpModel(model, client);  
        }
        
        Client savedRecord = clientService.save(client); 
        if(client.getBranchesYesNo().equals("Yes")){
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("New Client Was Added Successfully</br>You Can Add Branches!!!").messageType(MessageType.MESSAGE).build());           
        model.addAttribute("clickAddBranch", true); 
              
         redirectAttrs.addAttribute(savedRecord);
         return "redirect:/client/branch/addBranch/form";
        }
        Client u = new Client();
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("New Client Was Added Successfully").messageType(MessageType.MESSAGE).build());           
        model.addAttribute("clickAddClient", true); 
        return setUpModel(model, u);
              
   }
    
}
