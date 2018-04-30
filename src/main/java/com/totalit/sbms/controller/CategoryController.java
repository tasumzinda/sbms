/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.controller;

import com.totalit.sbms.domain.Category;
import com.totalit.sbms.service.CategoryService;
import com.totalit.sbms.service.UserService;
import com.totalit.sbms.utilities.AppMessage;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roy
 */
@Controller
@RequestMapping("/admin/category")
public class CategoryController {
   @Resource
   private CategoryService categoryService;
    
  @RequestMapping(value = {"/list"}, method = RequestMethod.GET) 
  public String listCategories(ModelMap model){
        ///model.addAttribute("message", new AppMessage.MessageBuilder().build());
        Category cat = new Category();
        model.addAttribute("pageTitle", "Category List");
        model.addAttribute("categories", cat);
        model.addAttribute("category", categoryService.getAll());
        model.addAttribute("clickListCategories", true);
        return "master";
  }
  
  
}
