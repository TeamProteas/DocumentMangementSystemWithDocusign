package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CheckStatusImplTest1 {
    @InjectMocks
    CheckStatusImpl checkStatus;


    @Test
    public void checkStatus1() throws IOException, ParseException {


        ResponseEntity<CustomResponse> responseEntity = checkStatus.checkStatus("mukul", "aadharcard");
        assertEquals(responseEntity.getStatusCode().toString(), "204 NO_CONTENT");
    }
}