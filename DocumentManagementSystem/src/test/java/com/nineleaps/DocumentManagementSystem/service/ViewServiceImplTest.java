package com.nineleaps.DocumentManagementSystem.service;


import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeDataRepository;
import com.nineleaps.DocumentManagementSystem.service.Impl.ViewServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
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
            12332232322l, 234423233l, "intern", "mukul","joshi");


    @Test
    public void fetchViewData() {
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


    }
}