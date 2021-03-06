package com.nineleaps.DocumentManagementSystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineleaps.DocumentManagementSystem.dto.EmailNotificationData;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.EmailNotificationImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.expression.Mvc;

import javax.mail.MessagingException;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EmailNotificationControllerTest {

    @InjectMocks
    EmailNotificationController emailNotificationController;

    @Autowired
    MockMvc mockMvc;
    @Mock
    EmailNotificationImpl notificationImpl;


    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(emailNotificationController)

                .build();
    }

    @Mock
    EmailNotificationData emailNotificationData;

    @Test
    public void htmlMail() throws Exception {
        EmailNotificationData emailNotificationData=new EmailNotificationData();
        ObjectMapper objectMapper=new ObjectMapper();
        String data=objectMapper.writeValueAsString(emailNotificationData);
        CustomResponse customResponse = new CustomResponse(new Date(), "Success",
                "Message Sent Sucessfully!", HttpStatus.CREATED.getReasonPhrase());

//       when(notificationImpl.sendHtmlMail("","","","")).thenReturn(new ResponseEntity<CustomResponse>(customResponse,HttpStatus.OK));


        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/v1/sendhtml")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(data)).andReturn();
        assertEquals(mvcResult.getResponse().getStatus(),200);







    }
}