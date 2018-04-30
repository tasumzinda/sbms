/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.service;

import com.totalit.sbms.domain.User;

/**
 *
 * @author user
 */
public interface UserService  extends GenericService<User>{
     public User findByUserName(String name);
 //   public User findByUserName(String name, Boolean active);

    public String getCurrentUsername();

    public User getCurrentUser();
    
    public User changePassword(User t);
    
       
    public void delete();
}
