package com.nineleaps.DocumentManagementSystem.elasticsearch;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.repository.ElasticSearchDataRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ElasticSearchDataLoaderTest {
    @InjectMocks
    ElasticSearchDataLoader loader;
    @Mock
    ElasticsearchOperations elasticsearchOperations;
    @Mock
    ElasticSearchDataRepository elasticSearchDataRepository;
    @Mock
    EmployeeAccountsRepository employeeAccountsRepository;



    EmployeeAccounts employeeAccounts = new EmployeeAccounts(false, "mukul.joshi@nineleaps.com", false, "NLI-132", "12345",
            12332232322l, 234423233l, "HR", "mukul", "joshi");


    EmployeeAccounts employeeAccounts1 = new EmployeeAccounts(false, "mukul.joshi@nineleaps.com", false, "NLI-132", "123456",
            12332232322l, 234423233l, "HR", "mukul", "joshi");
    @Test
    public void loadData() {
        List<EmployeeAccounts> employeeAcc=new ArrayList<EmployeeAccounts>();
        employeeAcc.add(employeeAccounts);
        employeeAcc.add(employeeAccounts1);
        when(employeeAccountsRepository.findAll()).thenReturn(employeeAcc);
        loader.loadData();
    }
}