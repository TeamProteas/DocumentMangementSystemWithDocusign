package com.nineleaps.DocumentManagementSystem.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ElasticSearchDataTest {

    @Test
    public void ElasticSearchData() throws JsonProcessingException {
        ObjectMapper objectMapper =new ObjectMapper();
        ElasticSearchData elasticSearchData =new ElasticSearchData();
        elasticSearchData.setUid("0e53fab4-9daa-4817-ba38-34d45e61ada3");
        elasticSearchData.setEmailId("mukul.joshi@nineleaps.com");
        String test=objectMapper.writeValueAsString(elasticSearchData);
        assertEquals(test,"{\"uid\":\"0e53fab4-9daa-4817-ba38-34d45e61ada3\",\"userId\":null,\"emailId\":\"mukul.joshi@nineleaps.com\"}");




    }



}