package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DemoConfig implements WebMvcConfigurer {

     @Override
     public void addCorsMappings(CorsRegistry registry) {

       registry.addMapping("/**")
               .allowedOrigins("*")
               .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "OPTIONS")
               .maxAge(300)
               .allowedHeaders("Authorization", "Cache-Control", "Content-Type");
     }
}
