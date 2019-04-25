package com.nineleaps.DocumentManagementSystem.service.Impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dto.SigninResponseData;
import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import org.elasticsearch.common.inject.matcher.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.powermock.api.mockito.PowerMockito.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest(SigninServiceImpl.class)
public class SigninServiceImplTest {

    @InjectMocks
    SigninServiceImpl signinService;

    @Mock
    SigninResponseData signinResponseData;

    @Mock
    TokenRequestedData tokenRequestedData;

    @Mock
    EmployeeAccountsRepository employeeAccountsRepository;




    EmployeeAccounts employeeAccounts = new EmployeeAccounts(false, "mukul.joshi@nineleaps.com", false, "NLI-132", "",
            12332232322l, 234423233l, "intern", "mukul", "joshi");


    @Test
    public void authorizeUser() throws Exception {
        ObjectMapper objectMapper=new ObjectMapper();
        when(tokenRequestedData.getGoogleId()).thenReturn("107583232828339878102");
        when(tokenRequestedData.getUserEmail()).thenReturn("mukul.joshi@nineleaps.com");
        when(employeeAccountsRepository.findbyEmailId(tokenRequestedData.getUserEmail())).thenReturn(employeeAccounts);
        doNothing().when(employeeAccountsRepository).updateGoogleId(anyString(),any());
        File file=mock(File.class);
        PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(file);


        SigninResponseData data = signinService.authorizeUser();
        String test=objectMapper.writeValueAsString(data);
        assertEquals(test,"{\"emailId\":\"mukul.joshi@nineleaps.com\",\"userId\":\"107583232828339878102\",\"view\":\"intern\"}");


    }

}
