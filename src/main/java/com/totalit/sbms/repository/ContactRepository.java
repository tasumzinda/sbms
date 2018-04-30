/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.repository;

import com.totalit.sbms.domain.Contact;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author user
 */
public interface ContactRepository extends JpaRepository<Contact, Long>{
    public List<Contact> findByClientId(Long id);
}
