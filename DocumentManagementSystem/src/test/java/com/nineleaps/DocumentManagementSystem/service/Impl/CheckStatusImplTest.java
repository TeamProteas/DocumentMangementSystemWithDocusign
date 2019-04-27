package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.DigitalSignData;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.repository.DigitalSignRepository;
import com.signaturit.api.java_sdk.Client;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@PrepareForTest({CheckStatusImpl.class, Response.class})
@RunWith(PowerMockRunner.class)
public class CheckStatusImplTest {

    @InjectMocks
    CheckStatusImpl checkStatus;

    @Mock
    Response response;
    @Mock
    DigitalSignRepository digitalSignRepo;

    @Test
    public void checkStatus() throws Exception {

        DigitalSignData digitalSignData = new DigitalSignData();
        when(digitalSignRepo.findDocumentRow("mukul", "aadharcard")).thenReturn(digitalSignData);
        Client client = PowerMockito.mock(Client.class);
        whenNew(Client.class).withAnyArguments().thenReturn(client);
        PowerMockito.mock(Response.class);
        when(client.getSignature(any())).thenReturn(response);
        ResponseBody my = Mockito.mock(ResponseBody.class, Mockito.CALLS_REAL_METHODS);
        when(response.body()).thenReturn(my);
        when(my.toString()).thenReturn("{\"created_at\":\"2019-04-11T12:22:07+0000\",\"data\":[],\"id\":\"35345f5f-35c0-47f6-aa88-ec9a502799b3\",\"documents\":[{\"created_at\":\"2019-04-11T12:22:07+0000\",\"file\":{\"name\":\"blank123__2_.pdf\",\"pages\":1,\"size\":845},\"id\":\"eb6e584a-0448-43f0-b2dc-967c5598cc2a\",\"events\":[{\"created_at\":\"2019-04-11T12:22:32+0000\",\"type\":\"email_processed\"},{\"created_at\":\"2019-04-11T12:22:33+0000\",\"type\":\"email_delivered\"},{\"created_at\":\"2019-04-11T13:54:10+0000\",\"type\":\"email_opened\"},{\"created_at\":\"2019-04-11T13:54:11+0000\",\"type\":\"email_opened\"},{\"created_at\":\"2019-04-11T13:54:13+0000\",\"type\":\"email_opened\"},{\"created_at\":\"2019-04-11T13:54:30+0000\",\"type\":\"document_opened\"},{\"created_at\":\"2019-04-11T13:54:50+0000\",\"type\":\"document_signed\"},{\"created_at\":\"2019-04-11T13:54:53+0000\",\"type\":\"document_completed\"},{\"created_at\":\"2019-04-11T13:54:56+0000\",\"type\":\"audit_trail_completed\"}],\"email\":\"ammy05534@gmail.com\",\"name\":\"HR head\",\"status\":\"completed\"}]}");

        ResponseEntity<CustomResponse> responseEntity = checkStatus.checkStatus("mukul", "aadharcard");
        assertEquals(responseEntity.getStatusCode().toString(), "200 OK");
    }

    @Test(expected = Exception.class)
    public void checkStatus1() throws IOException, ParseException {

        doThrow(Exception.class).when(digitalSignRepo).findDocumentRow(anyString(),anyString());
        Client client = PowerMockito.mock(Client.class);

        ResponseEntity<CustomResponse> responseEntity = checkStatus.checkStatus("mukul", "aadharcard");
        assertEquals(responseEntity.getStatusCode().toString(), "200 OK");


    }
}