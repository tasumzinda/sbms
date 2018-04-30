/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.repository;

import com.totalit.sbms.domain.AccountActivity;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author user
 */
public interface AccountActivityRepository extends JpaRepository<AccountActivity, Long>{
    
}
