package com.nineleaps.DocumentManagementSystem.service;


import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dto.SigninResponseData;
import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import com.nineleaps.DocumentManagementSystem.service.Impl.SigninServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
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
            12332232322l, 234423233l, "intern", "mukul","joshi");



    @Test
    public void authorizeUser() {
        when(tokenRequestedData.getGoogleId()).thenReturn("107583232828339878102");
        when(tokenRequestedData.getUserEmail()).thenReturn("mukul.joshi@nineleaps.com");
        when(employeeAccountsRepository.findbyEmailId(tokenRequestedData.getUserEmail())).thenReturn(employeeAccounts);
        doNothing().when(employeeAccountsRepository).updateGoogleId(anyString(), any());

        SigninResponseData data = signinService.authorizeUser();
        assertEquals(data.getEmailId(), "mukul.joshi@nineleaps.com");
        assertEquals(data.getUserId(), "107583232828339878102");
        assertEquals(data.getView(), "intern");
    }


}
