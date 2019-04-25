package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.dto.StatusTableData;
import com.nineleaps.DocumentManagementSystem.repository.DocumentTypeRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class StatusTableServiceImplTest {

    @InjectMocks
    StatusTableServiceImpl service;

    @Mock
    EmployeeAccountsRepository employeeAccountsRepository;
    @Mock
    EmployeeDataRepository employeeDataRepository;
    @Mock
    DocumentTypeRepository documentTypeRepository;
    @Mock
    StatusTableData statusTableData = new StatusTableData();


    EmployeeAccounts employeeAccounts = new EmployeeAccounts(false, "mukul.joshi@nineleaps.com", false, "NLI-132", "107583232828339878102",
            12332232322l, 234423233l, "intern", "mukul", "joshi");


    EmployeeData employeeData = new EmployeeData(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"), "pancard",
            "da0d1a7d-ac1e-47a0-bf45-c19ec50101aa", true, "mukul", "mukul",
            32343243243242l);


    @Test
    public void checkStatus() {
        List<EmployeeData> employeeData1=new ArrayList<EmployeeData>();
       when(employeeAccountsRepository.findbyGoogleId("123")).thenReturn(employeeAccounts);
       when(documentTypeRepository.count()).thenReturn(1l);
       service.checkStatus("123");

        when(employeeAccountsRepository.findbyGoogleId("123")).thenReturn(employeeAccounts);
        when(documentTypeRepository.count()).thenReturn(0l);
        service.checkStatus("123");
    }

    @Test
    public void getTableData() {
        List<EmployeeAccounts> employeeAccounts1=new ArrayList<EmployeeAccounts>();
        employeeAccounts1.add(0,employeeAccounts);
        when(employeeAccountsRepository.findAll()).thenReturn(employeeAccounts1);

        List<StatusTableData> statusTableData1 = service.getTableData();
        assertEquals(statusTableData1.size(), 1);


    }
}