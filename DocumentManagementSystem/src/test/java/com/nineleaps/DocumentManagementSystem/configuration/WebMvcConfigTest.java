package com.nineleaps.DocumentManagementSystem.configuration;

import com.nineleaps.DocumentManagementSystem.DocumentManagementInterceptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.config.annotation.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class WebMvcConfigTest {

    @InjectMocks
    WebMvcConfig webMvcConfig;
    @Mock
    ResourceHandlerRegistry resourceHandlerRegistry;
    @Mock
    ResourceHandlerRegistration resourceHandlerRegistration;
    @Mock
    InterceptorRegistry interceptorRegistry;
    @Mock
    InterceptorRegistration interceptorRegistration;
    @Mock
    DocumentManagementInterceptor documentManagementInterceptor;
    @Test
    public void addResourceHandlers() {

        when(resourceHandlerRegistry.addResourceHandler("/**")).thenReturn(resourceHandlerRegistration);
        webMvcConfig.addResourceHandlers(resourceHandlerRegistry);
    }

    @Test
    public void authorizationInterceptor() {
        DocumentManagementInterceptor documentManagementInterceptor=webMvcConfig.authorizationInterceptor();
    }

    @Test
    public void addInterceptors() {
        when(interceptorRegistry.addInterceptor(any())).thenReturn(interceptorRegistration);
        when(interceptorRegistration.addPathPatterns("/**")).thenReturn(interceptorRegistration);
        webMvcConfig.addInterceptors(interceptorRegistry);
    }

    @Test
    public void corsConfigurer() {
        WebMvcConfigurer webMvcConfigurer=webMvcConfig.corsConfigurer();
    }
}