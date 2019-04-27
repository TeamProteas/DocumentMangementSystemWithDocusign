package com.nineleaps.DocumentManagementSystem;

import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import static reactor.core.publisher.Mono.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DocumentManagementInterceptor.class, HttpClients.class, CloseableHttpResponse.class})
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


    @Test
    public void preHandle() throws Exception {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class, Mockito.RETURNS_MOCKS);
        PowerMockito.mockStatic(HttpClients.class);
        CloseableHttpClient closeableHttpClient=Mockito.mock(CloseableHttpClient.class,Mockito.CALLS_REAL_METHODS);
        when(HttpClients.createDefault())).
//        CloseableHttpClient closeableHttpClient=mock(CloseableHttpClient.class);
//        CloseableHttpClient httpClient=Mockito.mock(CloseableHttpClient.class);
//        whenNew(CloseableHttpClient.class).withAnyArguments().thenReturn(httpClient);


        boolean state = documentManagementInterceptor.preHandle(httpServletRequest, httpServletResponse, object);


    }

    @Test
    public void accessControl() {

    }
}