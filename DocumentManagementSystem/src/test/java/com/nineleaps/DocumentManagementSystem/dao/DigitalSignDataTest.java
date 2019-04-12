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
public class DigitalSignDataTest {

    @Test
    public void DigitalSignData() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        DigitalSignData digitalSignData = new DigitalSignData();
        digitalSignData.setDocumentId("abcde");
        digitalSignData.setDocumentName("jdshkjdfshds");
        digitalSignData.setFilename("jdshdfkj");
        digitalSignData.setPerson("kjsdkjdsh");
        digitalSignData.setSignatureRequestId("dksdhd");
        digitalSignData.setSignedby("kjdhkjfd");
        digitalSignData.setUid(UUID.fromString("da0d1a7d-ac1e-47a0-bf45-c19ec50101aa"));

        String test = objectMapper.writeValueAsString(digitalSignData);
        assertEquals(test, "{\"uid\":\"da0d1a7d-ac1e-47a0-bf45-c19ec50101aa\",\"filename\":\"jdshdfkj\",\"person\":\"kjsdkjdsh\",\"documentId\":\"abcde\",\"signatureRequestId\":\"dksdhd\",\"signedby\":\"kjdhkjfd\",\"documentName\":\"jdshkjdfshds\"}");

    }


}