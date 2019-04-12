package com.nineleaps.DocumentManagementSystem.controller;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

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


        mockMvc.perform(MockMvcRequestBuilders.post("v1/dsign")
                .accept(MediaType.ALL)
                .contentType(MediaType.ALL)
                .header("tokenId", "abcde")
                .param("signeeEmailId", "mukul.joshi@nineleaps.com")
                .param("signeeName", "anmol")
                .param("file", String.valueOf(multipartFile))
                .param("documentName", "pancard"));

        digitalSignController.digitalSign("mukul.joshi@nineleaps.com", "mukul.joshi@nineleaps.com", "anmol","mukul", multipartFile,"pancard");


    }
}