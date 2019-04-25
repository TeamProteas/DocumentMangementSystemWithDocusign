package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.DigitalSignData;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.repository.DigitalSignRepository;
import com.signaturit.api.java_sdk.Client;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GetSignFileImpl.class, Response.class})
public class GetSignFileImplTest {
    @InjectMocks
    GetSignFileImpl getSignFile;

    @Mock
    DigitalSignRepository digitalSignRepo;
    @Mock
    ResponseBody responseBody;


    @Test
    public void getFile() throws IOException {
        DigitalSignData digitalSignData = new DigitalSignData();
        when(digitalSignRepo.findDocumentRow("mukul", "pancard")).thenReturn(digitalSignData);
        ResponseEntity<CustomResponse> responseEntity = getSignFile.getFile("mukul", "pancard");
        assertEquals(responseEntity.getStatusCode().toString(), "403 FORBIDDEN");
    }
//
//    @Test
//    public void getFile1() throws Exception {
//        Client client = PowerMockito.mock(Client.class);
//        whenNew(Client.class).withAnyArguments().thenReturn(client);
////        ResponseBody responseBody=mock(ResponseBody.class);
////        whenNew(ResponseBody.class).withAnyArguments().thenReturn(responseBody);
//        File file = PowerMockito.mock(File.class);
//        whenNew(File.class).withAnyArguments().thenReturn(file);
//        OutputStream outputStream = mock(OutputStream.class);
//        whenNew(OutputStream.class).withAnyArguments().thenReturn(outputStream);
//        DigitalSignData digitalSignData = new DigitalSignData();
//        digitalSignData.setSignedby("sdsdddsds");
//        when(digitalSignRepo.findDocumentRow("mukul", "pancard")).thenReturn(digitalSignData);
//        Response response = mock(Response.class);
//        whenNew(Response.class).withAnyArguments().thenReturn(response);
//        when(response.body()).thenReturn(responseBody);
//
//
//        ResponseEntity<CustomResponse> responseEntity = getSignFile.getFile("mukul", "pancard");
//        assertEquals(responseEntity.getStatusCode().toString(), "403 FORBIDDEN");
//    }
}