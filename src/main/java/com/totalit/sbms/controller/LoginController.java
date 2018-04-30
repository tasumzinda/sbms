/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.controller;

import com.totalit.sbms.utilities.AppMessage;
import com.totalit.sbms.utilities.MessageType;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author user
 */
@Controller
public class LoginController extends BaseController{
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
    if (error != null){
    model.addAttribute("error", "Your username and password is invalid.");
    }
    if (logout != null){
    model.addAttribute("message", "You have been logged out successfully.");
    }
    return "login";
    }
    
    @RequestMapping(value = "/loginfailed")
    public String getloginFailed(ModelMap model) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Incorrect Username/Password").messageType(MessageType.ERROR).build());
        model.addAttribute("pageTitle", "Access Denied");
        return "login";
    }
    /*
    @RequestMapping(value = "/error",  method = RequestMethod.GET)
    public String getRedirectError(ModelMap model) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Access Denied");
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Incorrect Username/Password").messageType(MessageType.ERROR).build());
        return "login";
    }
*/
    @RequestMapping(value = "/success")
    public String getSuccess(ModelMap model) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
         model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Login Successfull!").messageType(MessageType.INFO).build());
        model.addAttribute("home", true);
        return "master";
    }

    @RequestMapping(value = "/logout")
    public String logout(ModelMap model, HttpSession httpSession) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("message", "Access Failed");
        httpSession.invalidate();
        return "redirect:login";

    }
    
    @RequestMapping(value = "/acceessdenied")
    public String accessDenied(ModelMap model, HttpSession httpSession) {
        model.addAttribute("pageTitle", "Access Denied");
        return "accessdenied";
    }
}
