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
public class EmployeeDataTest {

    @Test
    public void EmployeeData() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeData employeeData = new EmployeeData();
        employeeData.setVerifiedStatus(true);
        employeeData.setFileType("aadharcard");
        employeeData.setFolderUid("da0d1a7d-ac1e-47a0-bf45-c19ec50101aa");
        employeeData.setOrignalName("mukul joshi");
        employeeData.setUid(UUID.fromString("da0d1a7d-ac1e-47a0-bf45-c19ec50101aa"));
        employeeData.setUploadedBy("anmol taneja");
        employeeData.setUploadTime(1232321313l);
        String test=objectMapper.writeValueAsString(employeeData);
        assertEquals(test,"{\"uid\":\"da0d1a7d-ac1e-47a0-bf45-c19ec50101aa\",\"fileType\":\"aadharcard\",\"folderUid\":\"da0d1a7d-ac1e-47a0-bf45-c19ec50101aa\",\"verifiedStatus\":true,\"orignalName\":\"mukul joshi\",\"uploadedBy\":\"anmol taneja\",\"uploadTime\":1232321313}");

    }

}