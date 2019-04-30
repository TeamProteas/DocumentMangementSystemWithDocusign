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
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static org.junit.Assert.assertEquals;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest({GetSignFileImpl.class, Response.class,ResponseBody.class})
public class GetSignFileImplTest {

    @InjectMocks
    GetSignFileImpl getSignFile;

    @Mock
    DigitalSignRepository digitalSignRepo;
    @Mock
    ResponseBody responseBody;
    @Mock
    Response response;
    @Mock
    Client clients;



    @Test
    public void getFile() throws Exception {
        String str = "PANKAJ";
        byte[] byteArr = str.getBytes();


        DigitalSignData digitalSignData = new DigitalSignData();
        whenNew(Client.class).withAnyArguments().thenReturn(clients);
        when(digitalSignRepo.findDocumentRow("mukul", "pancard")).thenReturn(digitalSignData);
        OutputStream outputStream=mock(OutputStream.class);
        whenNew(OutputStream.class).withAnyArguments().thenReturn(outputStream);
        FileOutputStream fileOutputStream=mock(FileOutputStream.class);
        whenNew(FileOutputStream.class).withAnyArguments().thenReturn(fileOutputStream);

        File file = mock(File.class);
        whenNew(File.class).withAnyArguments().thenReturn(file);

        mock(Response.class);
        when(clients.downloadSignedDocument(any(),any())).thenReturn(response);

        ResponseBody my = PowerMockito.mock(ResponseBody.class, Mockito.RETURNS_MOCKS);


        when(response.body()).thenReturn(my);

        when(my.bytes()).thenReturn(null);
        ResponseEntity<CustomResponse> responseEntity = getSignFile.getFile("mukul", "pancard");
        assertEquals(responseEntity.getStatusCode().toString(), "200 OK");
    }

    @Test
    public void getFile1() throws Exception {


        DigitalSignData digitalSignData = new DigitalSignData();
        whenNew(Client.class).withAnyArguments().thenReturn(clients);
        when(digitalSignRepo.findDocumentRow("mukul", "pancard")).thenReturn(digitalSignData);
        OutputStream outputStream=mock(OutputStream.class);
        whenNew(OutputStream.class).withAnyArguments().thenReturn(outputStream);
        FileOutputStream fileOutputStream=mock(FileOutputStream.class);
        whenNew(FileOutputStream.class).withAnyArguments().thenReturn(fileOutputStream);
        ResponseEntity<CustomResponse> responseEntity = getSignFile.getFile("mukul", "pancard");
        assertEquals(responseEntity.getStatusCode().toString(), "403 FORBIDDEN");


    }




}