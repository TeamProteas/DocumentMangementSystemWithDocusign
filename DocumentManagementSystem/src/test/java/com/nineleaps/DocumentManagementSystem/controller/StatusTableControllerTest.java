package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.dto.StatusTableData;
import com.nineleaps.DocumentManagementSystem.service.Impl.StatusTableServiceImpl;
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

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class StatusTableControllerTest {
@InjectMocks
StatusTableController statusTableController;
    @Autowired
    MockMvc mockMvc;
    @Mock
    StatusTableServiceImpl statusTableService;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(statusTableController)

                .build();
    }
    @Test
    public void getstatus() throws Exception {
        List<StatusTableData> list=new ArrayList<StatusTableData>();
        when(statusTableService.getTableData()).thenReturn(list);

        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/v1/table")
                .accept(MediaType.ALL)
                .contentType(MediaType.ALL)).andReturn();

        assertEquals(mvcResult.getResponse().getStatus(),200);
        assertEquals(mvcResult.getResponse().getContentAsString(),"[]");
    }
}