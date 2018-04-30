/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.controller;

import com.totalit.sbms.domain.User;
import com.totalit.sbms.service.UserRoleService;
import com.totalit.sbms.service.UserService;
import com.totalit.sbms.utilities.AppMessage;
import com.totalit.sbms.utilities.MessageType;
import com.totalit.sbms.validator.UserValidator;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Roy
 */
@Controller
@RequestMapping("/admin")
public class UserController extends BaseController  {
    
    
    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRole;
    @Resource
    private UserValidator userValidator;
    
    /*
    public ModelAndView addUsers(){
        ModelAndView mv = new ModelAndView("master");
        User users =  new User();
        
        mv.addObject("pageTitle", "Add Users");
        mv.addObject("item", users);
        mv.addObject("userRoles", userRole.getAll());
        mv.addObject("clickAddUsers", true);
        return mv;
    }
*/
     @RequestMapping("/addUsers")
     public String addUsers(ModelMap model){
         User users =  new User();
         model.addAttribute("message", new AppMessage.MessageBuilder().build());
         model.addAttribute("pageTitle", "Add Users");
         model.addAttribute("item", users);
         model.addAttribute("user", userService.getCurrentUsername());
         model.addAttribute("userRoles", userRole.getAll());
         model.addAttribute("clickAddUsers", true);
         return "master";
     }
   private String setUpModel(ModelMap model, User item) {
        
        model.addAttribute("pageTitle", "Create/Edit User");   
        model.addAttribute("item", item);
        model.addAttribute("clickAddUsers", true);
        model.addAttribute("userRoles", userRole.getAll());
        return "master";
    }
    @RequestMapping(value = "/addUsers/form", method = RequestMethod.GET)
    public String userForm(ModelMap model, @RequestParam(required = false) Long id) {
       model.addAttribute("message", new AppMessage.MessageBuilder().build());
        User p = new User();
        if (id != null) {
            p = userService.get(id);
        }
        return setUpModel(model, p);
    }
   @RequestMapping(value = "/addUsers/form", method = RequestMethod.POST)
   public String saveUsers(@ModelAttribute("item") @Valid User user, BindingResult result, ModelMap model){  
       userValidator.validate(user, result);     
        if (result.hasErrors()) {   
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());           
        return setUpModel(model, user);  
        }
        
        userService.save(user); 
        User u = new User();
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("New User Was Created Successfully").messageType(MessageType.MESSAGE).build());           
        return setUpModel(model, u);
        //return "redirect:/addUsers";
        
   }
   @RequestMapping(value = {"/users/list"}, method = RequestMethod.GET)
    public String userList(ModelMap model) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "User List");
        model.addAttribute("items", userService.getAll());
        model.addAttribute("clickListUsers", true);
        return "master";
    }
 
}
