package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.exceptions.ViewNoRecordsFound;
import com.nineleaps.DocumentManagementSystem.service.Impl.DigitalSignImpl;
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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DigitalSignControllerTest {

    @InjectMocks
    DigitalSignController digitalSignController;

    @Autowired
    MockMvc mockMvc;

    @Mock
    DigitalSignImpl digitalSignImpl;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(digitalSignController)
                .build();
    }

    @Mock
    MultipartFile multipartFile;

    @Test
    public void digitalSign() throws Exception {
//        doNothing().when(digitalSignImpl).sendSignRequest("mukul.joshi@nineleaps.com", "anmol", "", multipartFile, "pancard");
        byte[] file = new byte[1];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("data", file);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.multipart("/v1/dsign")
                .file("file",mockMultipartFile.getBytes())
                .param("signeeEmailId", "mukul.joshi@nineleaps.com")
                .param("signeeName", "anmol")
                .param("name", "mukul")
                .param("documentName", "pancard")).andReturn();

        assertEquals(mvcResult.getResponse().getStatus(), 200);


    }
}