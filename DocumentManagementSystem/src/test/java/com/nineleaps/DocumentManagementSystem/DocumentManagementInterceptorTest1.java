package com.nineleaps.DocumentManagementSystem;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.exceptions.NotAllowedToUpload;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;


@RunWith(PowerMockRunner.class)
@SpringBootTest
public class DocumentManagementInterceptorTest1 {
    @InjectMocks
    DocumentManagementInterceptor documentManagementInterceptor;
    @Mock
    EmployeeAccountsRepository employeeAccountsRepo;

    EmployeeAccounts employeeAccounts1 = new EmployeeAccounts(false, "mukul.joshi@nineleaps.com", false, "NLI-132", "12345",
            12332232322l, 234423233l, "HRs", "mukul", "joshi");

    @Test(expected = NotAllowedToUpload.class)
    public void accessControl() {
        when(employeeAccountsRepo.findbyGoogleId("12345")).thenReturn(employeeAccounts1);
        documentManagementInterceptor.accessControl("12345", "123456");
    }
}
