package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeDataRepository;
import com.nineleaps.DocumentManagementSystem.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class VerifyServiceImpl implements VerifyService {
    @Autowired
    EmployeeDataRepository employeeDataRepository;
    @Autowired
    EmployeeAccountsRepository employeeAccountsRepository;
    @Autowired
    StatusTableServiceImpl statusTableService;

    @Override
    public ResponseEntity<CustomResponse> changeVerifyStatus(String userId, String fileType) {
        EmployeeAccounts employeeAccounts = employeeAccountsRepository.findbyGoogleId(userId);

        EmployeeData employeeData = employeeDataRepository.findFileRow(fileType, employeeAccounts.getUid().toString());
        if (employeeData.isVerifiedStatus() == true) {
            employeeDataRepository.setVerifyStatus(false, employeeData.getUid());
        } else {
            employeeDataRepository.setVerifyStatus(true, employeeData.getUid());
        }

        CustomResponse customResponse = new CustomResponse(new Date(), "Success",
                "the file Verified Status Changed", HttpStatus.OK.getReasonPhrase());

        statusTableService.checkStatus(userId);

        return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.OK);

    }
}
