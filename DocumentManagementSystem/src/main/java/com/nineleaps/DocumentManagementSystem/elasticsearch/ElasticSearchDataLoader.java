package com.nineleaps.DocumentManagementSystem.elasticsearch;

import com.nineleaps.DocumentManagementSystem.dao.ElasticSearchData;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.repository.ElasticSearchDataRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ElasticSearchDataLoader {

@Autowired
ElasticsearchOperations elasticsearchOperations;
@Autowired
ElasticSearchDataRepository elasticSearchDataRepository;
@Autowired
    EmployeeAccountsRepository employeeAccountsRepository;
@PostConstruct
@Transactional
public  void loadData(){

    List<EmployeeAccounts> employeeData = employeeAccountsRepository.findAll();

    ArrayList<ElasticSearchData> elasticSearchData=new ArrayList<ElasticSearchData>();
    for(EmployeeAccounts data:employeeData){
        elasticSearchData.add(new ElasticSearchData(data.getUid().toString(),data.getGoogleId(),data.getEmailId()));
    }
    elasticsearchOperations.putMapping(ElasticSearchData.class);
    elasticSearchDataRepository.saveAll(elasticSearchData);

}


}
