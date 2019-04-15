package com.nineleaps.DocumentManagementSystem.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CustomResponseTest {

    @Test
    public void Test() throws JsonProcessingException {
        Date date=new Date(11212112);
        ObjectMapper objectMapper=new ObjectMapper();
        CustomResponse customResponse=new CustomResponse();
        customResponse.setTimestamp(date);
        customResponse.setHttpCodeMessage("abc");
        customResponse.setDetails("abc");
        customResponse.setMessage("abc");
        String test=objectMapper.writeValueAsString(customResponse);
        assertEquals(test,"{\"httpCodeMessage\":\"abc\",\"timestamp\":11212112,\"message\":\"abc\",\"details\":\"abc\"}");
        assertEquals(customResponse.getTimestamp().hashCode(),11212112);
        assertEquals(customResponse.getMessage(),"abc");
        assertEquals(customResponse.getHttpCodeMessage(),"abc");
        assertEquals(customResponse.getDetails(),"abc");
        CustomResponse customResponse1=new CustomResponse(date,"abc","abc","abc");

        String test1=objectMapper.writeValueAsString(customResponse1);
        assertEquals(test1,"{\"httpCodeMessage\":\"abc\",\"timestamp\":11212112,\"message\":\"abc\",\"details\":\"abc\"}");



    }


}