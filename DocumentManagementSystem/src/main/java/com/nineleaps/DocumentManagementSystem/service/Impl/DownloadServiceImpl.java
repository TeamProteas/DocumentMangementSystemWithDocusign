package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeDataRepository;
import com.nineleaps.DocumentManagementSystem.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    EmployeeAccountsRepository employeeAccountRepo;

    @Autowired
    EmployeeDataRepository employeeDataRepo;

    @Autowired
    TokenRequestedData tokenRequestedData;

    @Override
    public ResponseEntity<Object> giveFile(String fileType) throws FileNotFoundException {


        EmployeeAccounts employeeAccounts = employeeAccountRepo.findbyEmailId(tokenRequestedData.getUserEmail());
        EmployeeData employeeData = employeeDataRepo.findFileRow(fileType, employeeAccounts.getUid().toString());
        if (employeeData != null) {
            System.out.println("file Available");

            String filename = "/home/nineleaps/Desktop/UserData/" + employeeAccounts.getUid().toString() + "/" + fileType;
            File file = new File(filename);
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", String.format("attachment;filename=\"%s\"", file.getName()));
            headers.add("Cache-Control", "no-cache,no-store,must revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("aplication/pdf")).body(resource);
            return responseEntity;
        } else {
            System.out.println("File not found");
            return null;

        }
    }
}
