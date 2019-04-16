package com.nineleaps.DocumentManagementSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class DocumentManagementSystemApplicationTests {
    @InjectMocks
    DocumentManagementSystemApplication application;
    @Mock
    SpringApplication springApplication;


    @Test
    public void contextLoads() {

        application.main(new String[] {});
    }

}
