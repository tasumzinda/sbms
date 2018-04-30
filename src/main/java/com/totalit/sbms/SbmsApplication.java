package com.totalit.sbms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
//@ComponentScan
public class SbmsApplication {
    
        @Bean
        public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/classes/messages");
        return messageSource;
        }
	public static void main(String[] args) {
		SpringApplication.run(SbmsApplication.class, args);
	}
     

}

