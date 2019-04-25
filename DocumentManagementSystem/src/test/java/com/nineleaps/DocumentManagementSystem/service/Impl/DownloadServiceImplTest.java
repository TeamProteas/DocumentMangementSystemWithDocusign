package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@PrepareForTest(DownloadServiceImpl.class)
@RunWith(PowerMockRunner.class)
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
    EmployeeData employeeData = new EmployeeData(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"), "hello.txt",
            "55c31946-88bb-482f-88c5-9185c2641243", true, "mukul", "mukul",
            32343243243242l);


    @Test
    public void giveFile() throws Exception {
        File file=mock(File.class);
        PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(file);
        FileInputStream inputStream=mock(FileInputStream.class);
        PowerMockito.whenNew(FileInputStream.class).withAnyArguments().thenReturn(inputStream);
        InputStreamResource inputStreamResource=mock(InputStreamResource.class);
        PowerMockito.whenNew(InputStreamResource.class).withAnyArguments().thenReturn(inputStreamResource);
        employeeAccounts.setUid(UUID.fromString("55c31946-88bb-482f-88c5-9185c2641243"));
        when(tokenRequestedData.getUserEmail()).thenReturn("mukul.joshi@nineleaps.com");
        when(employeeAccountRepo.findbyEmailId(tokenRequestedData.getUserEmail())).thenReturn(employeeAccounts);
        when(employeeDataRepo.findFileRow("hello.txt",employeeAccounts.getUid().toString())).thenReturn(employeeData);


        ResponseEntity<Object> customResponseResponseEntity = downloadService.giveFile("hello.txt");
        assertEquals(customResponseResponseEntity.getStatusCode().toString(),"200 OK");

        EmployeeData employeeData1=new EmployeeData();
        when(employeeDataRepo.findFileRow("hello.txt",employeeAccounts.getUid().toString())).thenReturn(null);
        ResponseEntity<Object> customResponseResponseEntitys = downloadService.giveFile("hello.txt");


    }
}