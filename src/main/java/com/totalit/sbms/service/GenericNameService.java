/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.service;

import java.io.Serializable;

/**
 *
 * @author user
 */
interface GenericNameService <T extends Serializable> extends GenericService<T> {
    public T getByName(String name);
    
}
