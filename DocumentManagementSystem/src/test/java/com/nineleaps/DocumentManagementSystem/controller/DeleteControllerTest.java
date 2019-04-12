package com.nineleaps.DocumentManagementSystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.DeleteServiceImpl;
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

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DeleteControllerTest {

    @InjectMocks
    DeleteController deleteController;

    @Mock
    DeleteServiceImpl deleteService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(deleteController)

                .build();
    }


    @Test
    public void deleteRequest() throws Exception {

        ResponseEntity<CustomResponse> entity=new ResponseEntity<CustomResponse>(HttpStatus.OK);
        when(deleteService.deleteRecord("pancard","107583232828339878102")).thenReturn(entity);

        mockMvc.perform(MockMvcRequestBuilders.post("v1/delete")
                .accept(MediaType.ALL)
                .contentType(MediaType.ALL)
                .header("tokenId", "abcde")
                .param("fileType","pancard")
                .param("userId","107583232828339878102"));
        ResponseEntity<CustomResponse> test=deleteController.deleteRequest("","pancard","107583232828339878102");

        assertEquals(test.getStatusCode().toString(),"200 OK");







    }
}