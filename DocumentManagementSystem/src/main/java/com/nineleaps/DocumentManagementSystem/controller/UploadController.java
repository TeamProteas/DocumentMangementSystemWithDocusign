package com.nineleaps.DocumentManagementSystem.controller;


import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.UploadServiceImpl;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
@CrossOrigin
@Controller
@RestController
public class UploadController {

    @Autowired
    UploadServiceImpl uploadServiceImpl;

    @Autowired
    TokenRequestedData tokenRequestedData;




    @ResponseBody
    @PostMapping(value = "/v1/upload")
    public ResponseEntity<CustomResponse> fetchData(@RequestParam("file") MultipartFile multipartFile,
                                                    @RequestParam("fileType") String fileType) throws IOException, ParseException {
        System.out.println("UPLOAD:");
        //System.out.println(tokenData);
        return uploadServiceImpl.storeData(multipartFile, fileType,tokenRequestedData.getUserId());

    }


}
