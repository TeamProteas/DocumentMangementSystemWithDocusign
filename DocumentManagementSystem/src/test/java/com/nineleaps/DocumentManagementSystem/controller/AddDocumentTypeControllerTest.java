
package com.nineleaps.DocumentManagementSystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineleaps.DocumentManagementSystem.dto.SigninResponseData;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.AddDocumentTypeServiceImpl;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AddDocumentTypeControllerTest {

    @InjectMocks
    private AddDocumentTypeController addDocumentTypeController;

    @Mock
    AddDocumentTypeServiceImpl addDocumentTypeService;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(addDocumentTypeController)
                .build();
    }


    @Test
    public void getNewDoctype() throws Exception {
        ResponseEntity<CustomResponse> responseEntity = new ResponseEntity<CustomResponse>(HttpStatus.OK);

        when(addDocumentTypeService.addDoctype("pancard", "Pan Card")).thenReturn(responseEntity);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/v1/doctype/add")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("fileType", "pancard")
                .param("displayName", "mukul"))
                .andReturn();
      assertEquals(mvcResult.getResponse().getStatus(),200);



    }
}

