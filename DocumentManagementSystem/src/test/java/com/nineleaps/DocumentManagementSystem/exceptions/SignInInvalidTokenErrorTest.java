package com.nineleaps.DocumentManagementSystem.exceptions;


import org.junit.runner.RunWith;

import org.junit.Test;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class SignInInvalidTokenErrorTest {


    @Test
    public void SignInInvalidToken(){
        SignInInvalidTokenError signInInvalidTokenError=new SignInInvalidTokenError("abc");
        assertEquals(signInInvalidTokenError.getMessage(),"abc");


    }


}