package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.exceptions.FileTypeEmpty;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;

@PrepareForTest(DeleteServiceImpl.class)
@RunWith(PowerMockRunner.class)
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
            12332232322l, 234423233l, "intern", "mukul", "joshi");

    EmployeeData employeeData = new EmployeeData(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"), "pancard",
            "da0d1a7d-ac1e-47a0-bf45-c19ec50101aa", true, "mukul", "mukul",
            32343243243242l);

    @Test
    public void deleteRecord() throws Exception {
        when(employeeAccountsRepo.findbyGoogleId("107583232828339878102")).thenReturn(employeeAccounts);
        when(employeeDataRepo.findFileRow("pancard", employeeAccounts.getUid().toString())).thenReturn(employeeData);
        doNothing().when(employeeDataRepo).deleteByUid(employeeData.getUid());
        doNothing().when(statusTableService).checkStatus("107583232828339878102");

        ResponseEntity<CustomResponse> customResponseResponseEntity = deleteService.deleteRecord("pancard", "107583232828339878102");
        assertEquals(customResponseResponseEntity.getStatusCode().getReasonPhrase(), "OK");

        when(employeeAccountsRepo.findbyGoogleId("107583232828339878102")).thenReturn(employeeAccounts);
        when(employeeDataRepo.findFileRow("pancard", employeeAccounts.getUid().toString())).thenReturn(employeeData);
        doNothing().when(employeeDataRepo).deleteByUid(employeeData.getUid());
        doNothing().when(statusTableService).checkStatus("107583232828339878102");
        File file = mock(File.class);
        PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(file);
        when(file.delete()).thenReturn(true);
        ResponseEntity<CustomResponse> customResponseResponseEntity1 = deleteService.deleteRecord("pancard", "107583232828339878102");
        assertEquals(customResponseResponseEntity1.getStatusCode().getReasonPhrase(), "OK");

        when(employeeAccountsRepo.findbyGoogleId("107583232828339878102")).thenReturn(employeeAccounts);
        when(employeeDataRepo.findFileRow("pancard", employeeAccounts.getUid().toString())).thenReturn(null);
        doNothing().when(employeeDataRepo).deleteByUid(employeeData.getUid());
        doNothing().when(statusTableService).checkStatus("107583232828339878102");
        when(file.delete()).thenReturn(true);

        ResponseEntity<CustomResponse> customResponseResponseEntity2 = deleteService.deleteRecord("pancard", "107583232828339878102");
        assertEquals(customResponseResponseEntity2.getStatusCode().getReasonPhrase(), "OK");
    }

    @Test(expected = FileTypeEmpty.class)
    public void deleteRecord1() throws Exception {

        when(employeeAccountsRepo.findbyGoogleId("107583232828339878102")).thenReturn(employeeAccounts);
        when(employeeDataRepo.findFileRow("pancard", employeeAccounts.getUid().toString())).thenReturn(null);
        doNothing().when(employeeDataRepo).deleteByUid(employeeData.getUid());
        doNothing().when(statusTableService).checkStatus("107583232828339878102");
        File file=mock(File.class);
        PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(file);
        when(file.delete()).thenReturn(true);
        ResponseEntity<CustomResponse> customResponseResponseEntity1 = deleteService.deleteRecord("pancard", "107583232828339878102");
        assertEquals(customResponseResponseEntity1.getStatusCode().getReasonPhrase(), "OK");

    }
}