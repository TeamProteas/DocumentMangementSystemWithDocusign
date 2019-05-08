package com.nineleaps.DocumentManagementSystem.configuration;

import com.nineleaps.DocumentManagementSystem.DocumentManagementInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/*  *")) {
            registry.addResourceHandler("/**").addResourceLocations(
                    CLASSPATH_RESOURCE_LOCATIONS);
        }
    }

    @Bean
    public DocumentManagementInterceptor authorizationInterceptor() {
        return new DocumentManagementInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/").allowedOrigins("*");
            }
        };
    }
}
