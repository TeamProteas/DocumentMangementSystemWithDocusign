package com.nineleaps.DocumentManagementSystem.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EmailNotificationDataTest {

    @Test
    public void EmailNotificationData() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        EmailNotificationData emailNotificationData=new EmailNotificationData();
        emailNotificationData.setDescription("OfferLetter");
        emailNotificationData.getEmailAddress();
        emailNotificationData.setName("mukul");
        String test=objectMapper.writeValueAsString(emailNotificationData);
        assertEquals(test,"{\"emailAddress\":null,\"name\":\"mukul\",\"description\":\"OfferLetter\"}");

    }

}