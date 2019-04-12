package com.nineleaps.DocumentManagementSystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.UploadServiceImpl;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;

import static org.junit.Assert.*;
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

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<CustomResponse> entity = new ResponseEntity<CustomResponse>(HttpStatus.OK);
        when(uploadService.storeData("abcde", multipart, "pancard", "107583232828339878102")).thenReturn(entity);

        mockMvc.perform(MockMvcRequestBuilders.post("v1/upload")
                .accept(MediaType.ALL)
                .contentType(MediaType.ALL)
                .header("tokenId", "abcde")
                .param("multipartfile", String.valueOf(multipart))
                .param("fileType", "pancard")
                .param("userId", "107583232828339878102"));

        ResponseEntity<CustomResponse> test = uploadController.fetchData("abcde", multipart, "pancard", "107583232828339878102");
        assertEquals(test.getStatusCode().toString(), "200 OK");


    }
}