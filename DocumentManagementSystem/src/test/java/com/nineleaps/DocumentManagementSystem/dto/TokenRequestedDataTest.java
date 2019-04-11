package com.nineleaps.DocumentManagementSystem.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TokenRequestedDataTest {

    @Test
    public void TokenRequestedData() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        TokenRequestedData tokenRequestedData = new TokenRequestedData();
        tokenRequestedData.setGoogleId("328712398171223");
        tokenRequestedData.setUserEmail("mukul.joshi@nineleaps.com");
        tokenRequestedData.setUserName("mukul joshi");
        String test=objectMapper.writeValueAsString(tokenRequestedData);
        assertEquals(test,"{\"googleId\":\"328712398171223\",\"userEmail\":\"mukul.joshi@nineleaps.com\",\"userName\":\"mukul joshi\"}");

    }

}