/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.repository;

import com.totalit.sbms.domain.RequiredDocuments;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author user
 */
public interface RequiredDocumentsRepository extends CrudRepository<RequiredDocuments, Long> {
    @Override
    public List<RequiredDocuments> findAll();
    public RequiredDocuments findByClientId(Long id);
}
