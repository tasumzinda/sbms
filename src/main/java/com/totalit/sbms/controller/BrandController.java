/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.controller;

import com.totalit.sbms.domain.Brand;
import com.totalit.sbms.domain.Category;
import com.totalit.sbms.domain.User;
import com.totalit.sbms.service.BrandService;
import com.totalit.sbms.service.CategoryService;
import com.totalit.sbms.service.UserService;
import com.totalit.sbms.utilities.AppMessage;
import com.totalit.sbms.utilities.MessageType;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/admin/brand")
public class BrandController {
    @Resource
    private UserService userService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private BrandService brandService;
    
    
    
     private String setUpModel(ModelMap model, Brand item) {
        model.addAttribute("pageTitle", "Brand List");
        model.addAttribute("category", categoryService.getAll());
        model.addAttribute("brand", item);
        model.addAttribute("brands", brandService.getAll());
        model.addAttribute("clickListBrands", true);
       
        return "master";
    }
  @RequestMapping(value = {"/list"}, method = RequestMethod.GET) 
  public String listBrands(ModelMap model){
        ///model.addAttribute("message", new AppMessage.MessageBuilder().build());
       
        Brand brand = new Brand();
        
        return setUpModel(model, brand);
  }
  @RequestMapping(value = {"/add"}, method = RequestMethod.POST) 
  public String addBrands(@ModelAttribute("brand") Brand brand, ModelMap model ){
        brandService.save(brand); 
        Brand u = new Brand();
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("New Brand Was Created Successfully").messageType(MessageType.MESSAGE).build());           
        return setUpModel(model, u);
  }
}
