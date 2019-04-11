package com.nineleaps.DocumentManagementSystem.configuration;

import com.nineleaps.DocumentManagementSystem.DocumentManagementInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {

            "classpath:/META-INF/resources/", "classpath:/resources/",

            "classpath:/static/", "classpath:/public/"};


    @Override

    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        if (!registry.hasMappingForPattern("/**")) {

            registry.addResourceHandler("/**").addResourceLocations(

                    CLASSPATH_RESOURCE_LOCATIONS);

        }

    }

    @Autowired
    DocumentManagementInterceptor documentManagementInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(documentManagementInterceptor).addPathPatterns("/**");

    }
}