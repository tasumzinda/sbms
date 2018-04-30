/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.service;

import com.totalit.sbms.domain.Contact;
import java.util.List;

/**
 *
 * @author user
 */
public interface ContactService extends GenericService<Contact>{
    List<Contact> findByClientId(Long id);
}
