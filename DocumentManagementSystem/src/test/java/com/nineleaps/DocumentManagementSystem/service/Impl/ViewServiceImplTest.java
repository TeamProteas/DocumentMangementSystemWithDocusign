package com.nineleaps.DocumentManagementSystem.service.Impl;


import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.exceptions.ViewNoRecordsFound;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeDataRepository;
import com.nineleaps.DocumentManagementSystem.service.Impl.ViewServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ViewServiceImplTest {
    @InjectMocks
    ViewServiceImpl viewService;
    @Mock
    EmployeeDataRepository employeeDataRepo;
    @Mock
    EmployeeAccountsRepository employeeAccountsRepository;


    EmployeeAccounts employeeAccounts = new EmployeeAccounts(false, "mukul.joshi@nineleaps.com", false, "NLI-132", "12345",
            12332232322l, 234423233l, "intern", "mukul", "joshi");

    EmployeeData employeeData1 = new EmployeeData(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"), "pancard",
            "da0d1a7d-ac1e-47a0-bf45-c19ec50101aa", true, "mukul", "mukul",
            32343243243242l);
    EmployeeData employeeData2 = new EmployeeData(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"), "pancard",
            "da0d1a7d-ac1e-47a0-bf45-c19ec50101aa", false, "mukul", "mukul",
            32343243243242l);
    @Test
    public void fetchViewData() throws Exception {
        List<EmployeeData> employeeData = new ArrayList<EmployeeData>();
        employeeData.add(employeeData1);
        employeeData.add(employeeData2);
        employeeAccounts.setUid(UUID.fromString("da0d1a7d-ac1e-47a0-bf45-c19ec50101aa"));
        when(employeeAccountsRepository.findbyGoogleId("12345")).thenReturn(employeeAccounts);
        when(employeeDataRepo.findByfolderUid(employeeAccounts.getUid().toString())).thenReturn(employeeData);

        List<EmployeeData> employeeDatas = viewService.fetchViewData("12345");
        assertEquals(employeeData.size(), 2);
    }

    @Test
    public void fetchViewData1() throws Exception {
        List<EmployeeData> employeeData = new ArrayList<EmployeeData>();
        employeeAccounts.setUid(UUID.fromString("da0d1a7d-ac1e-47a0-bf45-c19ec50101aa"));
        when(employeeAccountsRepository.findbyGoogleId("12345")).thenReturn(employeeAccounts);
        when(employeeDataRepo.findByfolderUid(employeeAccounts.getUid().toString())).thenReturn(employeeData);

        List<EmployeeData> employeeDatas = viewService.fetchViewData("12345");
        assertEquals(employeeData.size(), 0);


    }
}