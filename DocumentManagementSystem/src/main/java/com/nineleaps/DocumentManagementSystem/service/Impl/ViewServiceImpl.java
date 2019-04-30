package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeDataRepository;
import com.nineleaps.DocumentManagementSystem.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ViewServiceImpl implements ViewService {

    @Autowired
    EmployeeDataRepository employeeDataRepo;
    @Autowired
    EmployeeAccountsRepository employeeAccountsRepo;


    @Override
    public List<EmployeeData> fetchViewData(String userId) {
        EmployeeAccounts employeeAccounts = employeeAccountsRepo.findbyGoogleId(userId);
        List<EmployeeData> employeeData = employeeDataRepo.findByfolderUid(employeeAccounts.getUid().toString());

        //CHECKING IF USER HAS UPLOADED ANY DOCUMENTS OR NOT ,
        // IF NO DOCUMENTS ARE PRESENT IN THE DATABASE THEN THROW AN EXCEPTION
        System.out.println(employeeData.size());
        if (employeeData.size() == 0) {
            List<EmployeeData> employeeData1=new ArrayList<EmployeeData>();
            return employeeData1;
        }
        return employeeData;
    }
}
