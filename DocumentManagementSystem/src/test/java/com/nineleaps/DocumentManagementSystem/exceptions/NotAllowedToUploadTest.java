package com.nineleaps.DocumentManagementSystem.exceptions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class NotAllowedToUploadTest {

    @Test
    public void NotAllowedtoUpload(){
        NotAllowedToUpload notAllowedToUpload=new NotAllowedToUpload("abc");
        assertEquals(notAllowedToUpload.getMessage(),"abc");


    }



}