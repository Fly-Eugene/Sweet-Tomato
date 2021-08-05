//package com.ssafy.study_with_us.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//public class WebConfig implements WebMvcConfigurer {
//
//    @Value("${resources.location}")
//    private String resourcesLocation;
//    @Value("${resources.uri_path:}")
//    private String resourcesUriPath;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(resourcesUriPath + "/**")
//                .addResourceLocations("file://" + resourcesLocation);
//    }
//}