package com.nineleaps.DocumentManagementSystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.VerifyServiceImpl;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class VerifyControllerTest {
    @InjectMocks
    VerifyController verifyController;

    @Mock
    VerifyServiceImpl verifyService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(verifyController)

                .build();
    }




    @Test
    public void verifierStatus() throws Exception {


        ResponseEntity<CustomResponse> entity=new ResponseEntity<CustomResponse>(HttpStatus.OK);
        when(verifyService.changeVerifyStatus("107583232828339878102","pancard")).thenReturn(entity);

        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/v1/verify/status")
                .accept(MediaType.ALL)
                .contentType(MediaType.ALL)
                .param("userId","107583232828339878102")
                .param("fileType","pancard")).andReturn();

        assertEquals(mvcResult.getResponse().getStatus(),200);

    }
}