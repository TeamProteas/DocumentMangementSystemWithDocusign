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
        elasticSearchData.setUserId("abc");
        String test=objectMapper.writeValueAsString(elasticSearchData);
        assertEquals(test,"{\"uid\":\"0e53fab4-9daa-4817-ba38-34d45e61ada3\",\"userId\":\"abc\",\"emailId\":\"mukul.joshi@nineleaps.com\"}");

         ElasticSearchData elasticSearchData1=new ElasticSearchData("abc","abc","abc");
         String test1=objectMapper.writeValueAsString(elasticSearchData1);
         assertEquals(test1,"{\"uid\":\"abc\",\"userId\":\"abc\",\"emailId\":\"abc\"}");



    }



}