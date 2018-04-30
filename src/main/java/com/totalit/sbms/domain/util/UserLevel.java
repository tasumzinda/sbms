/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.domain.util;

import com.totalit.sbms.utilities.StringUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public enum UserLevel {
    ADMIN(1), USER(2), AGENT(3);
     private final Integer code;
    
    private UserLevel(Integer code){
        this.code = code;
    }
    
    public Integer getCode(){
        return code;
    }
    public static UserLevel get(Integer code){
        switch(code){
            case 1:
                return ADMIN;
            case 2:
                return USER;
            case 3:
                return AGENT;
            default:
                throw new IllegalArgumentException("Illegal parameter passed to method :" + code);
        }
    }
     public static List<UserLevel> getUserLevel(){
        List<UserLevel> items = new ArrayList<>();
        items.add(ADMIN);
        items.add(USER);
        items.add(AGENT);
        
        return items;
    }
     public String getName(){
        return StringUtils.toCamelCase3(super.name());
    }
}
