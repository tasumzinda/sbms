/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.service;

import com.totalit.sbms.domain.CustomUserDetails;
import com.totalit.sbms.domain.UserRole;
import com.totalit.sbms.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
     
    @Resource
    private UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     /*   Optional<User> optionalUser = userRepository.findByUserName(username);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        return optionalUser.map(CustomUserDetails::new).get();*/
    
        UserDetails userDetails = null;
        com.totalit.sbms.domain.User user = (com.totalit.sbms.domain.User) userService.findByUserName(username);
        if (user != null) {
            String password = user.getPassword();
            Set<UserRole> roles = user.getUserRoles();
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (UserRole role : roles) {
                String roleName = role.getName();
                authorities.add(new SimpleGrantedAuthority(roleName));
            }
            userDetails = new User(username, password, authorities);

        } else {
            // If username not found, throw exception
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        return userDetails;
    }
    
}
