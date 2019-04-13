package com.nineleaps.DocumentManagementSystem.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class StatusTableDataTest {
    @Test
    public void StatusTableData() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        StatusTableData statusTableData = new StatusTableData();
        statusTableData.setAllUploaded(true);
        statusTableData.setAllVerified(true);
        statusTableData.setEmailId("3234324324324");
        statusTableData.setEmployeeId("NLI-124");
        statusTableData.setFirstName("mukul");
        statusTableData.setLastName("joshi");
        String test=objectMapper.writeValueAsString(statusTableData);
        assertEquals(test,"{\"emailId\":\"3234324324324\",\"employeeId\":\"NLI-124\",\"allVerified\":true,\"allUploaded\":true,\"firstName\":\"mukul\",\"lastName\":\"joshi\"}");

        StatusTableData statusTableData1=new StatusTableData("ammy@gmail.com","NLI-124",true,true,"mukul","joshi");
        String test1=objectMapper.writeValueAsString(statusTableData1);
        assertEquals(test1,"{\"emailId\":\"ammy@gmail.com\",\"employeeId\":\"NLI-124\",\"allVerified\":true,\"allUploaded\":true,\"firstName\":\"mukul\",\"lastName\":\"joshi\"}");

    }

}