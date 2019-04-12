//package com.nineleaps.DocumentManagementSystem.service.Impl;
//
//import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
//import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
//import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
//import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
//import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
//import com.nineleaps.DocumentManagementSystem.repository.EmployeeDataRepository;
//import org.json.simple.parser.ParseException;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.UUID;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
//public class UploadServiceImplTest {
//
//    @InjectMocks
//    UploadServiceImpl uploadService;
//    @Mock
//    EmployeeAccountsRepository employeeAccountsRepo;
//    @Mock
//    EmployeeDataRepository employeeDataRepo;
//    @Mock
//    TokenRequestedData tokenRequestedData;
//    @Mock
//    StatusTableServiceImpl statusTableService;
//
//
//
//    EmployeeAccounts employeeAccounts = new EmployeeAccounts(false, "mukul.joshi@nineleaps.com", false, "NLI-132", "",
//            12332232322l, 234423233l, "intern", "mukul", "joshi");
//
//
//    EmployeeData employeeData = new EmployeeData(UUID.fromString("c465dd21-deda-400b-a788-179025e31898"), "pancard",
//            "da0d1a7d-ac1e-47a0-bf45-c19ec50101aa", true, "mukul", "mukul",
//            32343243243242l);
//
//    @Test
//    public void storeData() throws IOException, ParseException {
//        employeeAccounts.setUid(UUID.fromString("55c31946-88bb-482f-88c5-9185c2641243"));
//        File file=new File("/home/nineleaps/Documents/hello.txt");
//      //  FileOutputStream outputStream=new FileOutputStream(file);
//
//        FileInputStream inputStream=new FileInputStream(file);
//        MultipartFile result = new MockMultipartFile("hello.txt",
//               "hello.txt","text/plain",inputStream);
//
//        when(tokenRequestedData.getUserName()).thenReturn("mukul joshi");
//        when(tokenRequestedData.getGoogleId()).thenReturn("107583232828339878102");
//        when(employeeAccountsRepo.findbyGoogleId("107583232828339878102")).thenReturn(employeeAccounts);
//        when(employeeAccountsRepo.findbyGoogleId(tokenRequestedData.getGoogleId())).thenReturn(employeeAccounts);
//
//
//
//        //   doNothing().when(tokenRequestedData.getGoogleId().equals(anyString()));
//        when(employeeDataRepo.findFileRow(anyString(), anyString())).thenReturn(employeeData);
//
//        //  doNothing().when(employeeDataRepo).save(employeeData);
//        ResponseEntity<CustomResponse> test = uploadService.storeData("ejlklshakjhlksdha", result, "hello.txt", "107583232828339878102");
//        assertEquals(test.getStatusCode().getReasonPhrase(), "Created");
//
//
//    }
//}