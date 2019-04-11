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
public class DocumentTypeTest {

    @Test
    public void DocumentType() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        DocumentType documentType = new DocumentType();
        documentType.setDisplayName("Aadhar Card");
        documentType.setFileType("aadharcard");
        documentType.setUid(UUID.fromString("0e53fab4-9daa-4817-ba38-34d45e61ada3"));
        String test=objectMapper.writeValueAsString(documentType);
        assertEquals(test,"{\"uid\":\"0e53fab4-9daa-4817-ba38-34d45e61ada3\",\"fileType\":\"aadharcard\",\"displayName\":\"Aadhar Card\"}");
    }


}