package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class VerifyServiceImplTest {
    @InjectMocks
    VerifyServiceImpl verifyService;
    @Mock
    EmployeeDataRepository employeeDataRepository;
    @Mock
    EmployeeAccountsRepository employeeAccountsRepository;
    @Mock
    StatusTableServiceImpl statusTableService;

    EmployeeAccounts employeeAccounts = new EmployeeAccounts(false, "mukul.joshi@nineleaps.com", false, "NLI-132", "107583232828339878102",
            12332232322l, 234423233l, "intern", "mukul", "joshi");


    EmployeeData employeeData = new EmployeeData(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"), "pancard",
            "da0d1a7d-ac1e-47a0-bf45-c19ec50101aa", true, "mukul", "mukul",
            32343243243242l);

    @Test
    public void changeVerifyStatus() {
        when(employeeAccountsRepository.findbyGoogleId("107583232828339878102")).thenReturn(employeeAccounts);
        when(employeeDataRepository.findFileRow("pancard",employeeAccounts.getUid().toString())).thenReturn(employeeData);
       // doNothing().when(employeeData).setVerifiedStatus(true);

        ResponseEntity<CustomResponse> responseEntity=verifyService.changeVerifyStatus(employeeAccounts.getGoogleId(),"pancard");
        assertEquals(responseEntity.getStatusCode().getReasonPhrase(),"OK");







    }
}