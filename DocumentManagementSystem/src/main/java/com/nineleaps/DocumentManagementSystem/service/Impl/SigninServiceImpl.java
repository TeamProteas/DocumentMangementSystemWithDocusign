package com.nineleaps.DocumentManagementSystem.service.Impl;


import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dto.SigninResponseData;
import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.exceptions.SignInUserDataNotFound;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import com.nineleaps.DocumentManagementSystem.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class SigninServiceImpl implements SignInService {

    @Autowired
    EmployeeAccountsRepository employeeAccountRepo;

    @Autowired
    TokenRequestedData tokenRequestedData;

    @Override
    public SigninResponseData authorizeUser() {
//        System.out.println(tokenRequestedData.getGoogleId());
//        System.out.println(tokenRequestedData.getUserEmail());

        //UPDATING GOOGLE ID INTO THE DATABASE
        EmployeeAccounts data = employeeAccountRepo.findbyEmailId(tokenRequestedData.getUserEmail());
        employeeAccountRepo.updateGoogleId(tokenRequestedData.getGoogleId(), data.getUid());


        SigninResponseData signinResponseData = new SigninResponseData();
        signinResponseData.setEmailId(data.getEmailId());
        signinResponseData.setView(data.getDesignation());
        signinResponseData.setUserId(tokenRequestedData.getGoogleId());

        //CREATING A FOLDER FOR THE LOGGED IN USER
        String uid = "/home/nineleaps/Desktop/UserData/" + data.getUid().toString();
        new File(uid).mkdir();


        return signinResponseData;
    }

}







