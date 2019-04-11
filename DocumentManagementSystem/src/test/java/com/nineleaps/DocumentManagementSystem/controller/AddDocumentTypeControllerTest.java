/*
package com.nineleaps.DocumentManagementSystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static jdk.internal.vm.compiler.word.LocationIdentity.any;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AddDocumentTypeControllerTest {

    @InjectMocks
    private AddDocumentTypeController controller;

    @Mock
    AddDocumentTypeServiceImpl addDocumentTypeService;

    @Autowired
    private MockMvc mockMvc;


    ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setup() {

//initMocks(this);
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)

                .build();
    }


    @Test
    public void getNewDoctype() throws Exception {
        when(addDocumentTypeService.addDoctype(anyString(),"pancard","Pan Card")).thenReturn();

      String response=objectMapper.writeValueAsString();
        mockMvc.perform(MockMvcRequestBuilders.post("v1/doctype/add")
                .accept(MediaType.ALL)
                .contentType(MediaType.ALL)
                .header("tokenId",any())
                .param("fieldType","pancard")
                .param("displayName","Pan Card")
                .content(response));
    }
}*/
