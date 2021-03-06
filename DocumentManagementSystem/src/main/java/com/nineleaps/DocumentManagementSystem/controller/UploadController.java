package com.nineleaps.DocumentManagementSystem.controller;


import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.UploadServiceImpl;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@CrossOrigin
public class UploadController {

    @Autowired
    UploadServiceImpl uploadServiceImpl;

    @ResponseBody
    @PostMapping("/v1/upload")
    public ResponseEntity<CustomResponse> fetchData(@RequestParam("file") MultipartFile multipartFile,
                                                    @RequestParam("fileType") String fileType,
                                                    @RequestParam("userId") String userId) throws IOException, ParseException {

        return uploadServiceImpl.storeData(multipartFile, fileType, userId);
    }
}
