package com.nineleaps.DocumentManagementSystem;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.exceptions.NotAllowedToUpload;
import com.nineleaps.DocumentManagementSystem.exceptions.SignInInvalidTokenError;
import com.nineleaps.DocumentManagementSystem.exceptions.SignInUserDataNotFound;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
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
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest({HttpClients.class, CloseableHttpClient.class, EntityUtils.class})
public class DocumentManagementInterceptorTest {

    @InjectMocks
    DocumentManagementInterceptor interceptor;
    @Mock
    TokenRequestedData tokenRequestedData;
    @Mock
    EmployeeAccountsRepository employeeAccountsRepo;
    @Mock
    HttpServletResponse httpServletResponse;
    @Mock
    Object object;

    @Mock
    StatusLine statusLine;

    @Mock
    HttpEntity httpEntity;
    EmployeeAccounts employeeAccounts1 = new EmployeeAccounts(false, "mukul.joshi@nineleaps.com", false, "NLI-132", "12345",
            12332232322l, 234423233l, "HRs", "mukul", "joshi");


    @Test(expected = SignInInvalidTokenError.class)
    public void preHandle() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class, Mockito.RETURNS_MOCKS);
        PowerMockito.mockStatic(HttpClients.class);
        HttpGet httpGet = mock(HttpGet.class);
        whenNew(HttpGet.class).withAnyArguments().thenReturn(httpGet);
        CloseableHttpClient closeableHttpClient = mock(CloseableHttpClient.class, Mockito.RETURNS_MOCKS);
        when(HttpClients.createDefault()).thenReturn(closeableHttpClient);
        CloseableHttpResponse closeableHttpResponse = mock(CloseableHttpResponse.class,Mockito.RETURNS_MOCKS);
        when(closeableHttpClient.execute(any())).thenReturn(closeableHttpResponse);
        when(closeableHttpResponse.getStatusLine()).thenReturn(statusLine);
        when(statusLine.getStatusCode()).thenReturn(2);
        when(closeableHttpResponse.getEntity()).thenReturn(httpEntity);
        JSONParser jsonParser = mock(JSONParser.class);
        whenNew(JSONParser.class).withAnyArguments().thenReturn(jsonParser);
        boolean data = interceptor.preHandle(httpServletRequest, httpServletResponse, object);
    }

    @Test(expected = SignInUserDataNotFound.class)
    public void preHandle1() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class, Mockito.RETURNS_MOCKS);
        PowerMockito.mockStatic(HttpClients.class);
        HttpGet httpGet = mock(HttpGet.class);
        whenNew(HttpGet.class).withAnyArguments().thenReturn(httpGet);
        CloseableHttpClient closeableHttpClient = mock(CloseableHttpClient.class, Mockito.RETURNS_MOCKS);
        when(HttpClients.createDefault()).thenReturn(closeableHttpClient);
        CloseableHttpResponse closeableHttpResponse = mock(CloseableHttpResponse.class, Mockito.RETURNS_DEFAULTS);

        when(closeableHttpClient.execute(any())).thenReturn(closeableHttpResponse);
        when(closeableHttpResponse.getStatusLine()).thenReturn(statusLine);
        when(statusLine.getStatusCode()).thenReturn(200);
        when(closeableHttpResponse.getEntity()).thenReturn(httpEntity);
        PowerMockito.mockStatic(EntityUtils.class);
        when(EntityUtils.toString(httpEntity, "UTF-8")).thenReturn("{\"email\":\"abc\",\"sub\":\"abc\",\"name\":\"abc\"}");
        JSONObject jsonObject = mock(JSONObject.class);
        whenNew(JSONObject.class).withAnyArguments().thenReturn(jsonObject);
        EmployeeAccountsRepository employeeAccountsRepo = Mockito.mock(EmployeeAccountsRepository.class, Mockito.RETURNS_MOCKS);
        Mockito.when(employeeAccountsRepo.existsByEmailId(anyString())).thenReturn(false);


        boolean data = interceptor.preHandle(httpServletRequest, httpServletResponse, object);
    }


    @Test(expected = NotAllowedToUpload.class)
    public void preHandle2() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class, Mockito.RETURNS_MOCKS);
        PowerMockito.mockStatic(HttpClients.class);
        HttpGet httpGet = mock(HttpGet.class);
        whenNew(HttpGet.class).withAnyArguments().thenReturn(httpGet);
        CloseableHttpClient closeableHttpClient = mock(CloseableHttpClient.class, Mockito.RETURNS_MOCKS);
        when(HttpClients.createDefault()).thenReturn(closeableHttpClient);
        CloseableHttpResponse closeableHttpResponse = mock(CloseableHttpResponse.class, Mockito.RETURNS_DEFAULTS);

        when(closeableHttpClient.execute(any())).thenReturn(closeableHttpResponse);
        when(closeableHttpResponse.getStatusLine()).thenReturn(statusLine);
        when(statusLine.getStatusCode()).thenReturn(200);
        when(closeableHttpResponse.getEntity()).thenReturn(httpEntity);
        PowerMockito.mockStatic(EntityUtils.class);
        when(EntityUtils.toString(httpEntity, "UTF-8")).thenReturn("{\"email\":\"abc\",\"sub\":\"12345\",\"name\":\"abc\"}");
        JSONObject jsonObject = mock(JSONObject.class);
        whenNew(JSONObject.class).withAnyArguments().thenReturn(jsonObject);
        when(employeeAccountsRepo.existsByEmailId("abc")).thenReturn(true);
        when(httpServletRequest.getRequestURI()).thenReturn("/v1/upload");
        when(employeeAccountsRepo.findbyGoogleId("12345")).thenReturn(employeeAccounts1);

        boolean data = interceptor.preHandle(httpServletRequest, httpServletResponse, object);
    }


    @Test
    public void preHandle3() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class, Mockito.RETURNS_MOCKS);
        PowerMockito.mockStatic(HttpClients.class);
        HttpGet httpGet = mock(HttpGet.class);
        whenNew(HttpGet.class).withAnyArguments().thenReturn(httpGet);
        CloseableHttpClient closeableHttpClient = mock(CloseableHttpClient.class, Mockito.RETURNS_MOCKS);
        when(HttpClients.createDefault()).thenReturn(closeableHttpClient);
        CloseableHttpResponse closeableHttpResponse = mock(CloseableHttpResponse.class, Mockito.RETURNS_DEFAULTS);

        when(closeableHttpClient.execute(any())).thenReturn(closeableHttpResponse);
        when(closeableHttpResponse.getStatusLine()).thenReturn(statusLine);
        when(statusLine.getStatusCode()).thenReturn(200);
        when(closeableHttpResponse.getEntity()).thenReturn(httpEntity);
        PowerMockito.mockStatic(EntityUtils.class);
        when(EntityUtils.toString(httpEntity, "UTF-8")).thenReturn("{\"email\":\"abc\",\"sub\":\"12345\",\"name\":\"abc\"}");
        JSONObject jsonObject = mock(JSONObject.class);
        whenNew(JSONObject.class).withAnyArguments().thenReturn(jsonObject);
        when(employeeAccountsRepo.existsByEmailId("abc")).thenReturn(true);

        when(employeeAccountsRepo.findbyGoogleId("12345")).thenReturn(employeeAccounts1);

        boolean data = interceptor.preHandle(httpServletRequest, httpServletResponse, object);
        assertEquals(data,true);
    }

    @Test
    public void preHandle5() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class, Mockito.RETURNS_MOCKS);
        PowerMockito.mockStatic(HttpClients.class);
        HttpGet httpGet = mock(HttpGet.class);
        whenNew(HttpGet.class).withAnyArguments().thenReturn(httpGet);
        CloseableHttpClient closeableHttpClient = mock(CloseableHttpClient.class, Mockito.RETURNS_MOCKS);
        when(HttpClients.createDefault()).thenReturn(closeableHttpClient);
        CloseableHttpResponse closeableHttpResponse = mock(CloseableHttpResponse.class, Mockito.RETURNS_DEFAULTS);

        when(closeableHttpClient.execute(any())).thenReturn(closeableHttpResponse);
        when(closeableHttpResponse.getStatusLine()).thenReturn(statusLine);
        when(statusLine.getStatusCode()).thenReturn(200);
        when(closeableHttpResponse.getEntity()).thenReturn(httpEntity);
        PowerMockito.mockStatic(EntityUtils.class);
        when(EntityUtils.toString(httpEntity, "UTF-8")).thenReturn("{\"email\":\"abc\",\"sub\":\"12345\",\"name\":\"abc\"}");
        JSONObject jsonObject = mock(JSONObject.class);
        whenNew(JSONObject.class).withAnyArguments().thenReturn(jsonObject);
        when(employeeAccountsRepo.existsByEmailId("abc")).thenReturn(true);
        when(httpServletRequest.getRequestURI()).thenReturn("/v1/upload");
        employeeAccounts1.setDesignation("HR");

        when(employeeAccountsRepo.findbyGoogleId("12345")).thenReturn(employeeAccounts1);

        boolean data = interceptor.preHandle(httpServletRequest, httpServletResponse, object);
        assertEquals(data,true);
    }

    @Test
    public void prehandle4() throws Exception {

        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class, Mockito.RETURNS_MOCKS);
        when(httpServletRequest.getMethod()).thenReturn("OPTIONS");
//        when("abc".equalsIgnoreCase("OPTIONS")).thenReturn(false);
        boolean data = interceptor.preHandle(httpServletRequest, httpServletResponse, object);
        assertEquals(data,true);
    }

}