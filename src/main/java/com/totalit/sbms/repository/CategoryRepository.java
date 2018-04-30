/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.repository;

import com.totalit.sbms.domain.Category;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ROY
 */
public interface CategoryRepository extends CrudRepository<Category, Long>{
    @Override
    public List<Category> findAll();
    Category findByName(String name);
}
