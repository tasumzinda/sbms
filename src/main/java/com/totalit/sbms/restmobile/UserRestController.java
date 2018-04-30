/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.restmobile;

import com.totalit.sbms.domain.User;
import com.totalit.sbms.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/rest/user")
public class UserRestController {
    @Resource
    private UserService userService;
    
    @GetMapping("/all")
    public List<User> getAllUsers(){     
        return userService.getAll();
    }    
}
