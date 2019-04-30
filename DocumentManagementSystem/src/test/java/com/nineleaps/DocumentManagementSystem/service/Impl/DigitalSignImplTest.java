package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineleaps.DocumentManagementSystem.repository.DigitalSignRepository;
import com.signaturit.api.java_sdk.Client;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import okio.BufferedSource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileOutputStream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DigitalSignImpl.class, Response.class})
public class DigitalSignImplTest {

    @InjectMocks
    DigitalSignImpl digitalSign;
    @Mock
    DigitalSignRepository digitalSignRepos;
    @Mock
    Client client;

    @Mock
    JSONObject jsonObject;

    @Mock
    JSONParser parser;
    @Mock
    Response response;
    @Mock
    BufferedSource bufferedSource;
    RealResponseBody realResponseBody;

    ObjectMapper objectMapper;

    @Test
    public void sendSignRequest() throws Exception {
        byte[] files = new byte[1];
//        String test = "{\"emailId\":\"abc\",\"userId\":\"abc\",\"view\":\"abc\"}";
        objectMapper = new ObjectMapper();

        realResponseBody = new RealResponseBody("Test", 1l, bufferedSource);
        //jsonObject.put(realResponseBody, realResponseBody.contentType());
        MockMultipartFile mockMultipartFile = new MockMultipartFile("data", files);
        File file = mock(File.class);
        PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(file);
        FileOutputStream fileOutputStream = mock(FileOutputStream.class);
        PowerMockito.whenNew(FileOutputStream.class).withAnyArguments().thenReturn(fileOutputStream);
        PowerMockito.whenNew(Client.class).withAnyArguments().thenReturn(client);

        JSONObject mock = Mockito.mock(JSONObject.class);
        whenNew(JSONObject.class).withAnyArguments().thenReturn(mock);
        PowerMockito.mock(Response.class);
        when(client.createSignature(any(), any())).thenReturn(response);
        ResponseBody my = Mockito.mock(ResponseBody.class, Mockito.CALLS_REAL_METHODS);
        when(response.body()).thenReturn(my);
        when(my.toString()).thenReturn("{\"id\":\"123\", \"lastName\":\"Doe\"}");
//        when(parser.parse(anyString())).thenReturn(jsonObject);

        when(jsonObject.get(anyString())).thenReturn("1");


        digitalSign.sendSignRequest("mukul@nineleaps.com", "mukul", "joshi", mockMultipartFile, "fake");
    }
}