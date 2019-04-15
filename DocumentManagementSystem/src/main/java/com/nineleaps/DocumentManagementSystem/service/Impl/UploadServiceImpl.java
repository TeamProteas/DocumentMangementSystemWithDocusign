package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.exceptions.FileTypeEmpty;
import com.nineleaps.DocumentManagementSystem.exceptions.NotAllowedToUpload;
import com.nineleaps.DocumentManagementSystem.exceptions.UploadError;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeDataRepository;
import com.nineleaps.DocumentManagementSystem.service.UploadService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Component
public class UploadServiceImpl implements UploadService {
    @Autowired
    EmployeeAccountsRepository employeeAccountsRepo;
    @Autowired
    EmployeeDataRepository employeeDataRepo;
    @Autowired
    TokenRequestedData tokenRequestedData;
    @Autowired
    StatusTableServiceImpl statusTableService;


    @Override
    public ResponseEntity<CustomResponse> storeData(MultipartFile multipartFile, String fileType,String userId) throws IOException, ParseException {

        if (fileType.equals(null)) {
            throw new FileTypeEmpty("file type does not have any value");
        }




// FETCHING THE REQUIRED EMAIL RECORD AND THEN USING THE UID TO STORE AS FOLDERUID IN EMPLOYEE DATA
        long currentTime = Instant.now().toEpochMilli();

        EmployeeAccounts employeeAccountsId = employeeAccountsRepo.findbyGoogleId(userId);
        EmployeeAccounts employeeAccountsTokenId = employeeAccountsRepo.findbyGoogleId(tokenRequestedData.getGoogleId());
        if(tokenRequestedData.getGoogleId().equals(userId)){

            EmployeeData finddata = employeeDataRepo.findFileRow(fileType, employeeAccountsId.getUid().toString());
            if (finddata != null) {
                EmployeeData employeeData = new EmployeeData(finddata.getUid(), fileType,
                        employeeAccountsId.getUid().toString(),true, multipartFile.getOriginalFilename(), tokenRequestedData.getUserName(),
                        currentTime);
                employeeDataRepo.save(employeeData);
            } else {
                EmployeeData employeeData = new EmployeeData(UUID.randomUUID(), fileType,
                        employeeAccountsId.getUid().toString(),false, multipartFile.getOriginalFilename(), tokenRequestedData.getUserName(),
                        currentTime);
                employeeDataRepo.save(employeeData);
            }

        }
        else if (!tokenRequestedData.getGoogleId().equals(userId) && employeeAccountsTokenId.getDesignation().equals("HR")){



            EmployeeData finddata = employeeDataRepo.findFileRow(fileType, employeeAccountsId.getUid().toString());
            if (finddata != null) {
                EmployeeData employeeData = new EmployeeData(finddata.getUid(), fileType,
                        employeeAccountsId.getUid().toString(),true, multipartFile.getOriginalFilename(), tokenRequestedData.getUserName(),
                        currentTime);
                employeeDataRepo.save(employeeData);
            } else {
                EmployeeData employeeData = new EmployeeData(UUID.randomUUID(), fileType,
                        employeeAccountsId.getUid().toString(),false, multipartFile.getOriginalFilename(), tokenRequestedData.getUserName(),
                        currentTime);
                employeeDataRepo.save(employeeData);
            }

        }
        else{
            throw new NotAllowedToUpload("You are not allowed to upload into other employee accounts");
        }





        //saving data to the system
        try {
            File content = new File("/home/nineleaps/Desktop/UserData/" +
                    employeeAccountsId.getUid().toString() + "/" + fileType);
            content.createNewFile();
            FileOutputStream fout = new FileOutputStream(content);
            fout.write(multipartFile.getBytes());
            fout.close();
        } catch (Exception e) {
            throw new UploadError("There was some problem while uploading the file");
        }

        CustomResponse customResponse = new CustomResponse(new Date(), "Success",
                "the file was uploaded sucessfully!", HttpStatus.CREATED.getReasonPhrase());

        statusTableService.checkStatus(userId);

        return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.CREATED);
    }
}
