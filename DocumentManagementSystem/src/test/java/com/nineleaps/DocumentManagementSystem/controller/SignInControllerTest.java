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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class SignInControllerTest {
    @InjectMocks
    SignInController signInController;

    @Mock
    SigninServiceImpl signinService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(signInController)

                .build();
    }

    @Test
    public void SignInController() throws Exception {
        ObjectMapper objectMapper=new ObjectMapper();
        SigninResponseData data=new SigninResponseData("mukul.joshi@nineleaps.com","123456789","Intern");
        when(signinService.authorizeUser()).thenReturn(data);
        mockMvc.perform(MockMvcRequestBuilders.post("v1/signin")
                .accept(MediaType.ALL)
                .contentType(MediaType.ALL)
                .header("tokenId", "gkhgkkdjfsfhdflkshfdslhfskhfkdjsldljfhdflkjhfkdslfkh"));

        SigninResponseData test=signInController.signInRequest("");
        String mapper=objectMapper.writeValueAsString(test);
        assertEquals(mapper,"{\"emailId\":\"mukul.joshi@nineleaps.com\",\"userId\":\"123456789\",\"view\":\"Intern\"}");


    }

}