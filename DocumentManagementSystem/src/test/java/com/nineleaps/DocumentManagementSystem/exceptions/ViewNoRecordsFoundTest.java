package com.nineleaps.DocumentManagementSystem.exceptions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ViewNoRecordsFoundTest {

    @Test
    public void Test(){
        ViewNoRecordsFound viewNoRecordsFound=new ViewNoRecordsFound("abc");
        assertEquals(viewNoRecordsFound.getMessage(),"abc");
    }



}