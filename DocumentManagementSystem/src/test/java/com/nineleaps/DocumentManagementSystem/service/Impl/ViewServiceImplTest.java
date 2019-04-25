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
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ViewServiceImplTest {
    @InjectMocks
    ViewServiceImpl viewService;
    @Mock
    EmployeeDataRepository employeeDataRepo;
    @Mock
    EmployeeAccountsRepository employeeAccountsRepository;
    @Mock
    TokenRequestedData tokenRequestedData;

    EmployeeAccounts employeeAccounts = new EmployeeAccounts(false, "mukul.joshi@nineleaps.com", false, "NLI-132", "",
            12332232322l, 234423233l, "intern", "mukul", "joshi");


    @Test(expected = ViewNoRecordsFound.class)
    public void vfetchViewData() throws Exception {
        when(tokenRequestedData.getUserEmail()).thenReturn("mukul.joshi@nineleaps.com");
        when(employeeAccountsRepository.findbyEmailId("mukul.joshi@nineleaps.com")).thenReturn(employeeAccounts);
        when(employeeDataRepo.findByfolderUid(employeeAccounts.getUid().toString())).thenReturn(Stream
                .of(new EmployeeData(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"), "pancard",
                        "da0d1a7d-ac1e-47a0-bf45-c19ec50101aa", true, "mukul", "mukul",
                        32343243243242l), new EmployeeData(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"), "pancard",
                        "da0d1a7d-ac1e-47a0-bf45-c19ec50101aa", true, "mukul", "mukul",
                        32343243243242l)).collect(Collectors.toList()));

        List<EmployeeData> employeeData = viewService.fetchViewData();
        assertEquals(employeeData.size(), 2);

        List<EmployeeData> employeeData1 = new ArrayList<EmployeeData>();
        when(tokenRequestedData.getUserEmail()).thenReturn("mukul.joshi@nineleaps.com");
        when(employeeAccountsRepository.findbyEmailId("mukul.joshi@nineleaps.com")).thenReturn(employeeAccounts);
        when(employeeDataRepo.findByfolderUid(employeeAccounts.getUid().toString())).thenReturn(employeeData1);

        List<EmployeeData> employeeData3 = viewService.fetchViewData();
        assertEquals(employeeData3.size(), 0);


    }
}