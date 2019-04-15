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

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CheckStatusControllerTest {

    @InjectMocks
    CheckStatusController checkStatusController;
    @Mock
    CheckStatusImpl checkStatusImpl;
    @Autowired
    MockMvc mockMvc;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(checkStatusController)
                .build();
    }


    @Test
    public void status() throws Exception {

        when(checkStatusImpl.checkStatus("mukul", "pancard")).thenReturn("Signed");


        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("v1/checkstatus")
                .accept(MediaType.ALL)
                .contentType(MediaType.ALL)
                .header("tokenId", "abcde")
                .param("name", "mukul")
                .param("documentname", "pancard")
        ).andReturn();
          String responses=mvcResult.getResponse().getContentAsString();
        assertEquals(mvcResult.getResponse().getContentAsString(),"Signed");
        assertEquals(mvcResult.getResponse().getStatus(),200);


//        String test = checkStatusController.status("abcde", "mukul", "pancard");
//        assertEquals(test, "Signed");


    }
}