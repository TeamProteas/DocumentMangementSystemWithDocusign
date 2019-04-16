package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.GetSignFileImpl;
import okio.ByteString;
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

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class GetSignFileControllerTest {
    @InjectMocks
    GetSignFileController getSignFileController;
    @Autowired
    MockMvc mockMvc;
    @Mock
    GetSignFileImpl getSignFileImpl;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(getSignFileController)

                .build();
    }

    @Test
    public void getFile() throws Exception {
        ResponseEntity<CustomResponse> responseEntity=new ResponseEntity<CustomResponse>(HttpStatus.OK);
        when(getSignFileImpl.getFile("mukul","pancard")).thenReturn(responseEntity);


       MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/v1/getfile")
                .accept(MediaType.ALL)
                .contentType(MediaType.ALL)
                .param("name","mukul")
                .param("documentname","pancard")).andReturn();
        assertEquals(mvcResult.getResponse().getStatus(),200);
    }
}