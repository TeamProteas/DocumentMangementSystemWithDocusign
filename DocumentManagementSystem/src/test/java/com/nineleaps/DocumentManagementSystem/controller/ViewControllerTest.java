package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.service.Impl.VerifyServiceImpl;
import com.nineleaps.DocumentManagementSystem.service.Impl.ViewServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ViewControllerTest {

    @InjectMocks
    ViewController viewController;

    @Mock
    ViewServiceImpl viewService;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(viewController)

                .build();
    }

    @Test
    public void getView() throws Exception {
        List<EmployeeData> employeeData=new ArrayList<EmployeeData>();
        when(viewService.fetchViewData()).thenReturn(employeeData);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/view")
                .accept(MediaType.ALL)
                .contentType(MediaType.ALL)
                .header("tokenId", "a"));

        List<EmployeeData> test=viewController.getView("a");

        assertEquals(test.size(),0);



    }
}