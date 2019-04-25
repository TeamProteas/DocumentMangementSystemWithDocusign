package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.dto.StatusTableData;
import com.nineleaps.DocumentManagementSystem.repository.DocumentTypeRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeDataRepository;
import com.nineleaps.DocumentManagementSystem.service.StatusTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class StatusTableServiceImpl implements StatusTableService {

    @Autowired
    EmployeeAccountsRepository employeeAccountsRepository;
    @Autowired
    EmployeeDataRepository employeeDataRepository;
    @Autowired
    DocumentTypeRepository documentTypeRepository;

    @Override
    public void checkStatus(String userId){
        EmployeeAccounts employeeAccounts =employeeAccountsRepository.findbyGoogleId(userId);

        long docTypeEntries=documentTypeRepository.count();
        List<EmployeeData> employeeData =employeeDataRepository.findByfolderUid(employeeAccounts.getUid().toString());
        //for all uploaded
        int  employeeDataEntries=employeeData.size();
        if(employeeDataEntries == docTypeEntries)
            employeeAccountsRepository.updateallUploaded(true,employeeAccounts.getUid());
        else
            employeeAccountsRepository.updateallUploaded(false,employeeAccounts.getUid());

        //for all verified
        List<EmployeeData> employeeData1 =employeeDataRepository.findByfolderUidAndVerified(employeeAccounts.getUid().toString());
        int employeeVerifiedDocEntries=employeeData1.size();
        if(employeeVerifiedDocEntries == docTypeEntries)
            employeeAccountsRepository.updateallVerified(true,employeeAccounts.getUid());
        else
            employeeAccountsRepository.updateallVerified(false,employeeAccounts.getUid());

    }

    @Override
    public List<StatusTableData> getTableData() {
        List<EmployeeAccounts> employeeAccounts = employeeAccountsRepository.findAll();
        List<StatusTableData> statusTableData = new ArrayList<>();
        for (EmployeeAccounts emp : employeeAccounts) {
            statusTableData.add(new StatusTableData(emp.getEmailId(), emp.getEmployeeId(), emp.isAllVerified(), emp.isAllUploaded(), emp.getFirstName(), emp.getLastName()));
        }
        return statusTableData;
    }
}
