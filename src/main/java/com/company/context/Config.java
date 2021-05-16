package com.company.context;

import com.company.services.StackService;
import com.company.services.StackServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com.company.controllers", "com.company.services", "com.company.view"})
public class Config {
//
//    @Bean
//    @Scope("singleton")
//    public StackService stackService() {
//        return new StackServiceImpl();
//    }
}
