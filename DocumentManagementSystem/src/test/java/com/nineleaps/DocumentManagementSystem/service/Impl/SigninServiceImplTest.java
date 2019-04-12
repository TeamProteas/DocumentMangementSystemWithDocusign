//package com.nineleaps.DocumentManagementSystem.service.Impl;
//
//import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
//import com.nineleaps.DocumentManagementSystem.dto.SigninResponseData;
//import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
//import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//
//import java.io.File;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.*;
//import static org.powermock.api.mockito.PowerMockito.whenNew;
//
//@RunWith(MockitoJUnitRunner.class)
//@PrepareForTest(SigninServiceImpl.class)
//public class SigninServiceImplTest {
//
//    @InjectMocks
//    SigninServiceImpl signinService;
//
//    @Mock
//    File file;
//
//
//    @Mock
//    SigninResponseData signinResponseData;
//
//    @Mock
//    TokenRequestedData tokenRequestedData;
//
//    @Mock
//    EmployeeAccountsRepository employeeAccountsRepository;
//
//    EmployeeAccounts employeeAccounts = new EmployeeAccounts(false, "mukul.joshi@nineleaps.com", false, "NLI-132", "",
//            12332232322l, 234423233l, "intern", "mukul","joshi");
//
//
//    @Test
//    public void authorizeUser() throws Exception {
//        when(tokenRequestedData.getGoogleId()).thenReturn("107583232828339878102");
//        when(tokenRequestedData.getUserEmail()).thenReturn("mukul.joshi@nineleaps.com");
//        when(employeeAccountsRepository.findbyEmailId(tokenRequestedData.getUserEmail())).thenReturn(employeeAccounts);
//        doNothing().when(employeeAccountsRepository).updateGoogleId(anyString(), any());
//        doNothing().when(file.mkdir());
//
//      //  mockFolder = mock(File.class);
////        when(mockFolder.getPath()).thenReturn("Folder");
////        when(mockFolder.exists()).thenReturn(true);
////        when(mockFolder.mkdir()).thenReturn(true);
////        whenNew(File.class).withParameterTypes(String.class).withArguments(anyString()).thenReturn(mockFolder);
//
//        SigninResponseData data = signinService.authorizeUser();
//        assertEquals(data.getEmailId(), "mukul.joshi@nineleaps.com");
//        assertEquals(data.getUserId(), "107583232828339878102");
//        assertEquals(data.getView(), "intern");
//    }
//
//
//}
