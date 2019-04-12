package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.dao.ElasticSearchData;
import com.nineleaps.DocumentManagementSystem.elasticsearch.ElasticSearchQueryBuilder;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ElasticSearchControllerTest {

    @InjectMocks
    ElasticSearchController elasticSearchController;
    @Autowired
    MockMvc mockMvc;
    @Mock
    private ElasticSearchQueryBuilder elasticSearchQueryBuilder;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(elasticSearchController)

                .build();
    }

    @Test
    public void getall() throws Exception {
        List<ElasticSearchData> elasticSearchData = new ArrayList<ElasticSearchData>();
        when(elasticSearchQueryBuilder.getAll("muk")).thenReturn(elasticSearchData);

        mockMvc.perform(MockMvcRequestBuilders.post("v1/search")
                .accept(MediaType.ALL)
                .contentType(MediaType.ALL)
                .header("tokenId", "abcde")
                .param("text", "muk"));
        List<ElasticSearchData> test=elasticSearchController.getAll("abcde","muk");
        assertEquals(test.size(),0);

    }

}