package com.nineleaps.DocumentManagementSystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineleaps.DocumentManagementSystem.dto.SigninResponseData;
import com.nineleaps.DocumentManagementSystem.service.Impl.SigninServiceImpl;
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

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class SignInControllerTest {
    @InjectMocks
    SignInController signInController;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    SigninServiceImpl signinService;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(signInController)

                .build();
    }

    @Test
    public void signInRequest() throws Exception {
        ObjectMapper objectMapper=new ObjectMapper();

        SigninResponseData entity=new SigninResponseData("siddhantsharma@gmail.com","108887776","fhdfh");
        when(signinService.authorizeUser()).thenReturn(entity);

        mockMvc.perform(MockMvcRequestBuilders.post("v1/delete")
                .accept(MediaType.ALL)
                .contentType(MediaType.ALL)
                .header("tokenId", "abcde"));


        SigninResponseData test=signInController.signInRequest("abcde");
        String mapper=objectMapper.writeValueAsString(test);

        assertEquals(mapper,"{\"emailId\":\"siddhantsharma@gmail.com\",\"userId\":\"108887776\",\"view\":\"fhdfh\"}");

    }
}