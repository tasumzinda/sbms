/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.service.impl;

import com.totalit.sbms.domain.User;
import com.totalit.sbms.repository.UserRepository;
import com.totalit.sbms.service.UserService;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService{
    
    @Resource
    private UserRepository userRepository;

   /* @Override
    public  Optional<Users> findByUserName(String name) {
        return userRepository.findByUserName(name);
    }*/
     @Override
    public User findByUserName(String name) {
        return userRepository.findByUserName(name);
    }


    @Override
    public String getCurrentUsername() {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal() == null) {
            return null;
        }
        if (authentication.getPrincipal() instanceof String) {
            String principal = (String) authentication.getPrincipal();

            if (principal.compareTo("anonymousUser") != 0) {
                return null;
            }
            return principal;
        }
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }

    @Override
    public User getCurrentUser() {
        String username = getCurrentUsername();
        if (username == null) {
            return null;
        }
        User user = findByUserName(username);
        if (user == null) {
            return null;
        }
        return user;
    }

    @Override
    public User changePassword(User t) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode(t.getPassword());
        t.setPassword(hashedPassword);
        t.setModifiedBy(getCurrentUser());
        t.setDateModified(new Date());
        return userRepository.save(t);
    }

    @Override
    public void delete() {
        for (User item : getAll()) {
            String userName = item.getUserName();
            List<User> currentUsers = (List<User>) userRepository.findByUserName(userName);
            if (currentUsers.size() > 1) {
        
                List<User> duplicates = currentUsers.subList(1, currentUsers.size());
                for (User toDelete : duplicates) {
                    try {
                        
                        delete(toDelete);
                        
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        continue;
                    }

                }
            }
        }
    }

    @Override
    public List<User> getAll() {
        return  userRepository.findAll();
    }

    @Override
    public User get(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void delete(User t) {
         if (t.getId() == null) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        userRepository.save(t);
    }

    @Override
    public List<User> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User save(User t) {
         if (t.getId() == null) {
            t.setCreatedBy(getCurrentUser());
            t.setDateCreated(new Date());
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String hashedPassword = encoder.encode(t.getPassword());
            t.setPassword(hashedPassword);
            return userRepository.save(t);
        }
        t.setModifiedBy(getCurrentUser());
        t.setDateModified(new Date());
        return userRepository.save(t);
    }

    @Override
    public Boolean checkDuplicate(User current, User old) {
       if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getUserName().equals(old.getUserName())) {
                if (findByUserName(current.getUserName()) != null) {
                    return true;
                }
            }

        } else if (current.getId() == null) {
            /**
             * @param current is new
             */
            if (findByUserName(current.getUserName()) != null) {
                return true;
            }
        }
        return false;
    }

  

   
    
    
}
