package com.nineleaps.DocumentManagementSystem.service;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeDataRepository;
import com.nineleaps.DocumentManagementSystem.service.Impl.DownloadServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DownloadServiceImplTest {
    @InjectMocks
    DownloadServiceImpl downloadService;

    @Mock
    EmployeeAccountsRepository employeeAccountRepo;
    @Mock
    EmployeeDataRepository employeeDataRepo;
    @Mock
    TokenRequestedData tokenRequestedData;


    EmployeeAccounts employeeAccounts = new EmployeeAccounts(false, "mukul.joshi@nineleaps.com", false, "NLI-132", "",
            12332232322l, 234423233l, "intern", "mukul","joshi");
    EmployeeData employeeData = new EmployeeData(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"), "pancard",
            "da0d1a7d-ac1e-47a0-bf45-c19ec50101aa", true, "mukul", "mukul",
            32343243243242l);


    @Test
    public void giveFile() throws FileNotFoundException {
        when(tokenRequestedData.getUserEmail()).thenReturn("mukul.joshi@nineleaps.com");
        when(employeeAccountRepo.findbyEmailId(tokenRequestedData.getUserEmail())).thenReturn(employeeAccounts);
        when(employeeDataRepo.findFileRow("pancard",employeeAccounts.getUid().toString())).thenReturn(employeeData);


        ResponseEntity<Object> customResponseResponseEntity = downloadService.giveFile("pancard");
        assertEquals(customResponseResponseEntity,"file not found");

    }
}