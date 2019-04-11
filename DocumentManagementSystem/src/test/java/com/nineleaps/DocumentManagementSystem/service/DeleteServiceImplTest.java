package com.nineleaps.DocumentManagementSystem.service;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeDataRepository;
import com.nineleaps.DocumentManagementSystem.service.Impl.DeleteServiceImpl;
import com.nineleaps.DocumentManagementSystem.service.Impl.StatusTableServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DeleteServiceImplTest {
    @InjectMocks
    DeleteServiceImpl deleteService;

    @Mock
    EmployeeAccountsRepository employeeAccountsRepo;
    @Mock
    EmployeeDataRepository employeeDataRepo;
    @Mock
    TokenRequestedData tokenRequestedData;
    @Mock
    StatusTableServiceImpl statusTableService;

    EmployeeAccounts employeeAccounts = new EmployeeAccounts(false, "mukul.joshi@nineleaps.com", false, "NLI-132", "107583232828339878102",
            12332232322l, 234423233l, "intern", "mukul","joshi");

    EmployeeData employeeData = new EmployeeData(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"), "pancard",
            "da0d1a7d-ac1e-47a0-bf45-c19ec50101aa", true, "mukul", "mukul",
            32343243243242l);

    @Test
    public void deleteRecord() {
        when(employeeAccountsRepo.findbyGoogleId("107583232828339878102")).thenReturn(employeeAccounts);
        when(employeeDataRepo.findFileRow("pancard", employeeAccounts.getUid().toString())).thenReturn(employeeData);
        doNothing().when(employeeDataRepo).deleteByUid(employeeData.getUid());
        doNothing().when(statusTableService).checkStatus("107583232828339878102");

        ResponseEntity<CustomResponse> customResponseResponseEntity = deleteService.deleteRecord("pancard", "107583232828339878102");
        assertEquals(customResponseResponseEntity.getStatusCode().getReasonPhrase(), "OK");
    }
}