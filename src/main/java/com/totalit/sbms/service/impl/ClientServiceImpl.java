/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.service.impl;

import com.totalit.sbms.domain.Client;
import com.totalit.sbms.repository.ClientRepository;
import com.totalit.sbms.service.ClientService;
import com.totalit.sbms.service.UserService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
public class ClientServiceImpl implements ClientService{

    @Resource
    private ClientRepository clientRepository;
    @Resource
    private UserService userService;
    @Override
    public Client getByName(String name) {
        if (name == null) {
            throw new IllegalStateException("Item to be read does not exist:");
        }
        return clientRepository.findByName(name);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
        
    }

    @Override
    public Client get(Long id) {
        if (id == null) {
            throw new IllegalStateException("Item to be deleted does not exist:");
        }
        Optional<Client> o =  clientRepository.findById(id);
        return o.get();
    }

    @Override
    public void delete(Client t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Client> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client save(Client t) {
        if (t.getId() == null) {
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return clientRepository.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return clientRepository.save(t);
    }

    @Override
    public Boolean checkDuplicate(Client current, Client old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
