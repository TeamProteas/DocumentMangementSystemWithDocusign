package com.nineleaps.DocumentManagementSystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineleaps.DocumentManagementSystem.dao.DocumentType;
import com.nineleaps.DocumentManagementSystem.service.Impl.DocumentTypeServiceImpl;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DocumentTypeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @InjectMocks
    DocumentTypeController documentTypeController;
    @Mock
    DocumentTypeServiceImpl documentTypeServiceImpl;


    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(documentTypeController)

                .build();
    }

    @Test
    public void getTypes() throws Exception {

        List<DocumentType> documentTypes = new ArrayList<DocumentType>();
        when(documentTypeServiceImpl.fetchTypeOfDocument()).thenReturn(documentTypes);


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/v1/doctype")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        assertEquals(mvcResult.getResponse().getContentAsString(),"[]");
        assertEquals(mvcResult.getResponse().getStatus(), 200);


    }
}
