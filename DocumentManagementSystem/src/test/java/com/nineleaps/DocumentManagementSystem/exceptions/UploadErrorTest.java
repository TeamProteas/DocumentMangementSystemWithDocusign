package com.nineleaps.DocumentManagementSystem.exceptions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UploadErrorTest {

    @Test
    public  void Test(){
        UploadError uploadError=new UploadError("abc");
        assertEquals(uploadError.getMessage(),"abc");

    }

}