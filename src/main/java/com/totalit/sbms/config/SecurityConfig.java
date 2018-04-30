/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.config;

/**
 *
 * @author Roy
 */

import com.totalit.sbms.repository.UserRepository;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

   @Autowired
   private UserDetailsService userDetailsService;

       
   /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{        
    //   auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
    }*/
       private PasswordEncoder getPasswordEncoder(){
           return new PasswordEncoder() {
           @Override
           public String encode(CharSequence cs) {
               return cs.toString();
           }

           @Override
           public boolean matches(CharSequence cs, String string) {
               return true;
           }
       };
       }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
       // http.authorizeRequests().antMatchers("**/secure/**").authenticated().anyRequest().permitAll().and()
       http.authorizeRequests().antMatchers("/user/**", "/client/**").authenticated().anyRequest().permitAll().and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/success").usernameParameter("username")
				.passwordParameter("password").failureUrl("/loginfailed").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login").and().exceptionHandling()
				.accessDeniedPage("/access-denied");
    }
    @Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/admin/addUsers", "/rest/**");
	}
        
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        }
}
