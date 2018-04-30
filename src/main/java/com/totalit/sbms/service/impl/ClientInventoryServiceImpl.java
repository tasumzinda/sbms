/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.service.impl;

import com.totalit.sbms.domain.ClientInventory;
import com.totalit.sbms.repository.ClientInventoryRepository;
import com.totalit.sbms.service.ClientInventoryService;
import com.totalit.sbms.service.UserService;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Repository
public class ClientInventoryServiceImpl implements ClientInventoryService{
    @Resource
    private ClientInventoryRepository  cir;
    @Resource UserService userService;

   
     @Override
    public List<ClientInventory> findByClientId(Long id) {
        return cir.findByClientId(id);
    }
    @Override
    public List<ClientInventory> getAll() {
        return cir.findAll();
    }

    @Override
    public ClientInventory get(Long id) {
        return cir.getOne(id);
    }

    @Override
    public void delete(ClientInventory t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClientInventory> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClientInventory save(ClientInventory t) {
         if (t.getId() == null) {
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return cir.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return cir.save(t);
    }

    @Override
    public Boolean checkDuplicate(ClientInventory current, ClientInventory old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
