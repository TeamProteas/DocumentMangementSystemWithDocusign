package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.VerifyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VerifyController {

    @Autowired
    VerifyServiceImpl verifyService;

    @ResponseBody
    @PostMapping("/v1/verify/status")
    public ResponseEntity<CustomResponse> verifierStatus(@RequestParam("userId") String userId, @RequestParam("fileType") String fileType) {
        return  verifyService.changeVerifyStatus(userId, fileType);


    }


}
