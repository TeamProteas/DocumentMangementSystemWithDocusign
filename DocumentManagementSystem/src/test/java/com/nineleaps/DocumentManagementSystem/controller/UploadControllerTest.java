package com.nineleaps.DocumentManagementSystem.controller;

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
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UploadControllerTest {
    @InjectMocks
    UploadController uploadController;
    @Mock
    UploadServiceImpl uploadService;
    @Mock
    MockMultipartFile mockMultipartFile;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(uploadController)

                .build();
    }


    @Test
    public void fetchData() throws Exception {
        String s = "skjdhsjkdkshjdkdldlsadhlsafhldfhjkdfahdsdhdjsdhfdjshgdshfgdf";
        byte[] file = s.getBytes();
//        MockMultipartFile mockMultipartFile = new MockMultipartFile("data", file);
        ResponseEntity<CustomResponse> entity = new ResponseEntity<CustomResponse>(HttpStatus.OK);
//        when(uploadService.storeData(mockMultipartFile, "pancard", "107583232828339878102")).thenReturn(entity);


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.multipart("/v1/upload")
                .file("file", mockMultipartFile.getBytes())
//                .param("file",mockMultipartFile.getBytes().toString())
                .param("fileType", "pancard")
                .param("userId", "107583232828339878102")).andReturn();
        assertEquals(mvcResult.getResponse().getStatus(), 200);


    }
}