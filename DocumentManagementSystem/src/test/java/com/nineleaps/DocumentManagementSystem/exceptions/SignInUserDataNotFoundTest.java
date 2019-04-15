package com.nineleaps.DocumentManagementSystem.exceptions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class SignInUserDataNotFoundTest {

    @Test
    public void test(){
        SignInUserDataNotFound signInUserDataNotFound=new SignInUserDataNotFound("abc");
        assertEquals(signInUserDataNotFound.getMessage(),"abc");

    }

}