/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.service;

import com.totalit.sbms.domain.RequiredDocuments;

/**
 *
 * @author user
 */
public interface RequiredDocumentsService extends GenericService<RequiredDocuments> {
    public RequiredDocuments findByClient(Long id);
    
}
