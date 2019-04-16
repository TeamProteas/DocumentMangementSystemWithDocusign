package com.nineleaps.DocumentManagementSystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.UploadServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UploadControllerTest {
    @InjectMocks
    UploadController uploadController;

    @Autowired
    private MockMvc mockMvc;


    @Mock
    UploadServiceImpl uploadService;

    @Mock
    MultipartFile multipart;


    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(uploadController)

                .build();
    }


    @Test
    public void fetchData() throws Exception {
        ResponseEntity<CustomResponse> entity = new ResponseEntity<CustomResponse>(HttpStatus.OK);
        when(uploadService.storeData(multipart, "pancard", "107583232828339878102")).thenReturn(entity);
        byte[] file = new byte[1];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("data", file);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.multipart("/v1/upload")
                .file("file",mockMultipartFile.getBytes())
                .param("fileType", "pancard")
                .param("userId", "107583232828339878102")).andReturn();
        assertEquals(mvcResult.getResponse().getStatus(), 200);


    }
}