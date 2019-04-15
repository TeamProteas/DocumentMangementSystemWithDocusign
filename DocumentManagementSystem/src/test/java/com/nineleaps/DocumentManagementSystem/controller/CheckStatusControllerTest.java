package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.service.Impl.CheckStatusImpl;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static sun.rmi.transport.TransportConstants.Return;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CheckStatusControllerTest {

    @InjectMocks
    CheckStatusController checkStatusController;
    @Mock
    CheckStatusImpl checkStatusImpl;
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;
    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(checkStatusController)
                .build();
    }


    @Test
    public void status() throws Exception {

        when(checkStatusImpl.checkStatus("mukul","pancard")).thenReturn("Signed");


      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/v1/checkstatus")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)

                .header("tokenId", "abcde")
                .param("name", "mukul")
                .param("documentname", "pancard")


      ).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
       int status = mvcResult.getResponse().getStatus();
       assertEquals(200,status);




       assertEquals(content,"Signed");


        //String test=checkStatusController.status("abcde","mukul","pancard");
        //assertEquals(test,"Signed");








    }
}