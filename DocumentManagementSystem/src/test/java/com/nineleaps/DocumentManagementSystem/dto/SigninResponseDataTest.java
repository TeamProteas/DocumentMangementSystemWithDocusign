package com.nineleaps.DocumentManagementSystem.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SigninResponseDataTest {


    @Test
    public void SigninResponseData() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        SigninResponseData signinResponseData=new SigninResponseData();
        signinResponseData.setUserId("12321323233233");
        signinResponseData.setEmailId("mukul.joshi@nineleaps.com");
        signinResponseData.setView("Intern");
        String test=objectMapper.writeValueAsString(signinResponseData);
        assertEquals(test,"{\"emailId\":\"mukul.joshi@nineleaps.com\",\"userId\":\"12321323233233\",\"view\":\"Intern\"}");

    }
}