package com.nineleaps.DocumentManagementSystem;

import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import okhttp3.Response;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DocumentManagementInterceptor.class,HttpClients.class,CloseableHttpResponse.class})
public class DocumentManagementInterceptorTest {

    @InjectMocks
    DocumentManagementInterceptor documentManagementInterceptor;
    @Mock
    EmployeeAccountsRepository employeeAccountsRepo;
    @Mock
    TokenRequestedData tokenRequestedData;

    @Mock
    HttpServletResponse httpServletResponse;
    @Mock
    HttpServletRequest httpServletRequest;
    @Mock
    Object object;
    @Mock
    CloseableHttpClient closeableHttpClient;
    @Mock
    CloseableHttpResponse response;



    @Test
    public void preHandle() throws Exception {

        PowerMockito.mockStatic(HttpClients.class);
        when(HttpClients.createDefault()).thenReturn(closeableHttpClient);
//        PowerMockito.mockStatic(CloseableHttpResponse.class);
//        CloseableHttpResponse closeableHttpResponse=mock(CloseableHttpResponse.class);
        when(response.getStatusLine().getStatusCode()).thenReturn(311);

//        when(closeableHttpResponse.getStatusLine().getStatusCode()).thenReturn(300);
        boolean state = documentManagementInterceptor.preHandle(httpServletRequest, httpServletResponse, object);


    }

    @Test
    public void accessControl() {

    }
}