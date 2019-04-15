package com.nineleaps.DocumentManagementSystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.DownloadServiceImpl;
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

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DownloadControllerTest {

    @InjectMocks
    DownloadController downloadController;

    @Mock
    DownloadServiceImpl downloadService;

    @Autowired
    private MockMvc mockMvc;


    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(downloadController)

                .build();
    }

    @Test
    public void downloadFile() throws Exception {


        ResponseEntity<Object> entity = new ResponseEntity<Object>(HttpStatus.OK);
        when(downloadService.giveFile("pancard")).thenReturn(entity);

       MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/v1/download")
                .accept(MediaType.ALL)
                .contentType(MediaType.ALL)
                .param("file", "pancard")).andReturn();
        assertEquals(mvcResult.getResponse().getStatus(),200);


    }
}