package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.exceptions.NotAllowedToUpload;
import com.nineleaps.DocumentManagementSystem.exceptions.UploadError;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;


@RunWith(PowerMockRunner.class)
@PrepareForTest(UploadServiceImpl.class)
public class UploadServiceImplTest {

    @InjectMocks
    UploadServiceImpl uploadService;
    @Mock
    EmployeeAccountsRepository employeeAccountsRepo;
    @Mock
    EmployeeDataRepository employeeDataRepo;
    @Mock
    TokenRequestedData tokenRequestedData;
    @Mock
    StatusTableServiceImpl statusTableService;


    EmployeeAccounts employeeAccounts = new EmployeeAccounts(false, "mukul.joshi@nineleaps.com", false, "NLI-132", "12345",
            12332232322l, 234423233l, "HR", "mukul", "joshi");


    EmployeeAccounts employeeAccounts1 = new EmployeeAccounts(false, "mukul.joshi@nineleaps.com", false, "NLI-132", "123456",
            12332232322l, 234423233l, "HR", "mukul", "joshi");

    EmployeeData employeeData = new EmployeeData(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"), "pancard",
            "da0d1a7d-ac1e-47a0-bf45-c19ec50101aa", true, "mukul", "mukul",
            32343243243242l);

    @Test
    public void storeData() throws Exception {
        byte[] file = new byte[1];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("data", file);
        employeeAccounts.setUid(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"));
        when(tokenRequestedData.getGoogleId()).thenReturn("12345");
        when(employeeAccountsRepo.findbyGoogleId("12345")).thenReturn(employeeAccounts);
        when(employeeAccountsRepo.findbyGoogleId(tokenRequestedData.getGoogleId())).thenReturn(employeeAccounts);
        when(employeeDataRepo.findFileRow("pancard", "c465dd21-deda-400b-a788-179025e31898")).thenReturn(employeeData);
        File file1 = mock(File.class);
        whenNew(File.class).withAnyArguments().thenReturn(file1);
        FileOutputStream fileOutputStream = mock(FileOutputStream.class);
        whenNew(FileOutputStream.class).withAnyArguments().thenReturn(fileOutputStream);

        ResponseEntity<CustomResponse> responseEntity = uploadService.storeData(mockMultipartFile, "pancard", "12345");
        assertEquals(responseEntity.getStatusCode().toString(), "201 CREATED");

    }

    @Test
    public void storeData1() throws Exception {
        byte[] file = new byte[1];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("data", file);
        employeeAccounts.setUid(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"));
        when(tokenRequestedData.getGoogleId()).thenReturn("12345");
        when(employeeAccountsRepo.findbyGoogleId("12345")).thenReturn(employeeAccounts);
        when(employeeAccountsRepo.findbyGoogleId(tokenRequestedData.getGoogleId())).thenReturn(employeeAccounts);
        File file1 = mock(File.class);
        whenNew(File.class).withAnyArguments().thenReturn(file1);
        FileOutputStream fileOutputStream = mock(FileOutputStream.class);
        whenNew(FileOutputStream.class).withAnyArguments().thenReturn(fileOutputStream);

        ResponseEntity<CustomResponse> responseEntity1 = uploadService.storeData(mockMultipartFile, "pancard", "12345");
        assertEquals(responseEntity1.getStatusCode().toString(), "201 CREATED");


    }

    @Test
    public  void storedata3() throws Exception{
        byte[] file = new byte[1];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("data", file);
        employeeAccounts.setUid(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"));
        when(tokenRequestedData.getGoogleId()).thenReturn("12345");
        when(employeeAccountsRepo.findbyGoogleId("123456")).thenReturn(employeeAccounts);
        employeeAccounts1.setUid(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"));
        when(employeeAccountsRepo.findbyGoogleId(tokenRequestedData.getGoogleId())).thenReturn(employeeAccounts1);

        when(employeeDataRepo.findFileRow("pancard",employeeAccounts.getUid().toString())).thenReturn(employeeData);
        File file1 = mock(File.class);
        whenNew(File.class).withAnyArguments().thenReturn(file1);
        FileOutputStream fileOutputStream = mock(FileOutputStream.class);
        whenNew(FileOutputStream.class).withAnyArguments().thenReturn(fileOutputStream);

        ResponseEntity<CustomResponse> responseEntity1 = uploadService.storeData(mockMultipartFile, "pancard", "123456");
        assertEquals(responseEntity1.getStatusCode().toString(), "201 CREATED");
    }

    @Test
    public  void storedata4() throws Exception{
        byte[] file = new byte[1];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("data", file);
        employeeAccounts.setUid(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"));
        when(tokenRequestedData.getGoogleId()).thenReturn("12345");
        when(employeeAccountsRepo.findbyGoogleId("123456")).thenReturn(employeeAccounts);
        employeeAccounts1.setUid(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"));
        when(employeeAccountsRepo.findbyGoogleId(tokenRequestedData.getGoogleId())).thenReturn(employeeAccounts1);

        when(employeeDataRepo.findFileRow("pancard",employeeAccounts.getUid().toString())).thenReturn(null);
        File file1 = mock(File.class);
        whenNew(File.class).withAnyArguments().thenReturn(file1);
        FileOutputStream fileOutputStream = mock(FileOutputStream.class);
        whenNew(FileOutputStream.class).withAnyArguments().thenReturn(fileOutputStream);

        ResponseEntity<CustomResponse> responseEntity1 = uploadService.storeData(mockMultipartFile, "pancard", "123456");
        assertEquals(responseEntity1.getStatusCode().toString(), "201 CREATED");
    }

    @Test(expected = NotAllowedToUpload.class)
    public  void storedata5() throws Exception{

        byte[] file = new byte[1];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("data", file);
        employeeAccounts.setUid(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"));
        when(tokenRequestedData.getGoogleId()).thenReturn("12345");
        when(employeeAccountsRepo.findbyGoogleId("123456")).thenReturn(employeeAccounts);
        employeeAccounts1.setUid(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"));
        employeeAccounts1.setDesignation("jhjj");
        when(employeeAccountsRepo.findbyGoogleId(tokenRequestedData.getGoogleId())).thenReturn(employeeAccounts1);

        when(employeeDataRepo.findFileRow("pancard",employeeAccounts.getUid().toString())).thenReturn(null);
        File file1 = mock(File.class);
        whenNew(File.class).withAnyArguments().thenReturn(file1);
        FileOutputStream fileOutputStream = mock(FileOutputStream.class);
        whenNew(FileOutputStream.class).withAnyArguments().thenReturn(fileOutputStream);

        ResponseEntity<CustomResponse> responseEntity1 = uploadService.storeData(mockMultipartFile, "pancard", "123456");
        assertEquals(responseEntity1.getStatusCode().toString(), "201 CREATED");
    }

    @Test(expected = UploadError.class)
    public  void storedata6() throws Exception{

        byte[] file = new byte[1];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("data", file);
        employeeAccounts.setUid(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"));
        when(tokenRequestedData.getGoogleId()).thenReturn("12345");
        when(employeeAccountsRepo.findbyGoogleId("12345")).thenReturn(employeeAccounts);
        when(employeeAccountsRepo.findbyGoogleId(tokenRequestedData.getGoogleId())).thenReturn(employeeAccounts);
        when(employeeDataRepo.findFileRow("pancard", "c465dd21-deda-400b-a788-179025e31898")).thenReturn(employeeData);
        File file1 = mock(File.class);
        whenNew(File.class).withAnyArguments().thenReturn(file1);


        ResponseEntity<CustomResponse> responseEntity = uploadService.storeData(mockMultipartFile, "pancard", "12345");
        assertEquals(responseEntity.getStatusCode().toString(), "201 CREATED");



    }

}