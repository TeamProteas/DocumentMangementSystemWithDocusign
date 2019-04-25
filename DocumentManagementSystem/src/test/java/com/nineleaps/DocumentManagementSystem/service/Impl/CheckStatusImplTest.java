//package com.nineleaps.DocumentManagementSystem.service.Impl;
//
//import com.nineleaps.DocumentManagementSystem.dao.DigitalSignData;
//import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
//import com.nineleaps.DocumentManagementSystem.repository.DigitalSignRepository;
//import okhttp3.Response;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.ParseException;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
//public class CheckStatusImplTest {
//
//    @InjectMocks
//    CheckStatusImpl checkStatus;
//
//    @Mock
//    DigitalSignRepository digitalSignRepo;
//    @Mock
//    JSONObject json;
//
//
//    @Test
//    public void checkStatus() throws IOException, ParseException {
//        ArrayList ar=new ArrayList();
//        ar.add(0,"{\"created_at\":\"2019-04-11T12:22:07+0000\",\"file\":{\"name\":\"blank123__2_.pdf\",\"pages\":1,\"size\":845},\"id\":\"eb6e584a-0448-43f0-b2dc-967c5598cc2a\",\"events\":[{\"created_at\":\"2019-04-11T12:22:32+0000\",\"type\":\"email_processed\"},{\"created_at\":\"2019-04-11T12:22:33+0000\",\"type\":\"email_delivered\"},{\"created_at\":\"2019-04-11T13:54:10+0000\",\"type\":\"email_opened\"},{\"created_at\":\"2019-04-11T13:54:11+0000\",\"type\":\"email_opened\"},{\"created_at\":\"2019-04-11T13:54:13+0000\",\"type\":\"email_opened\"},{\"created_at\":\"2019-04-11T13:54:30+0000\",\"type\":\"document_opened\"},{\"created_at\":\"2019-04-11T13:54:50+0000\",\"type\":\"document_signed\"},{\"created_at\":\"2019-04-11T13:54:53+0000\",\"type\":\"document_completed\"},{\"created_at\":\"2019-04-11T13:54:56+0000\",\"type\":\"audit_trail_completed\"}],\"email\":\"ammy05534@gmail.com\",\"name\":\"HR head\",\"status\":\"completed\"}");
//
//        DigitalSignData digitalSignData=new DigitalSignData();
//        when(digitalSignRepo.findDocumentRow("mukul","aadharcard")).thenReturn(digitalSignData);
////        when(json.get("documents")).thenReturn(ar);
//
//
//        ResponseEntity<CustomResponse> responseEntity=checkStatus.checkStatus("mukul","aadharcard");
//        assertEquals(responseEntity.getStatusCode(),"");
//
//
//    }
//}