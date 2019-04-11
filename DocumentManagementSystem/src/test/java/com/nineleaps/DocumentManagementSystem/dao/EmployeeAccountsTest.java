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
public class EmployeeAccountsTest {

    @Test
    public void EmployeeAccounts() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        EmployeeAccounts employeeAccounts=new EmployeeAccounts();
        employeeAccounts.setUid(UUID.fromString("da0d1a7d-ac1e-47a0-bf45-c19ec50101aa"));
        employeeAccounts.setAllUploaded(true);
        employeeAccounts.setAllVerified(true);
        employeeAccounts.setDateOfBirth(1232333333l);
        employeeAccounts.setDateOfJoining(1232132323l);
        employeeAccounts.setDesignation("intern");
        employeeAccounts.setEmailId("mukul.joshi@nineleaps.com");
        employeeAccounts.setEmployeeId("NLI-123");
        employeeAccounts.setFirstName("mukul joshi");
        employeeAccounts.setGoogleId("3987432732732");
        employeeAccounts.setLastName("joshi");

        String test=objectMapper.writeValueAsString(employeeAccounts);
        assertEquals(test,"{\"uid\":\"da0d1a7d-ac1e-47a0-bf45-c19ec50101aa\",\"allUploaded\":true,\"emailId\":\"mukul.joshi@nineleaps.com\",\"allVerified\":true,\"employeeId\":\"NLI-123\",\"googleId\":\"3987432732732\",\"dateOfBirth\":1232333333,\"dateOfJoining\":1232132323,\"designation\":\"intern\",\"firstName\":\"mukul joshi\",\"lastName\":\"joshi\"}");


    }


}