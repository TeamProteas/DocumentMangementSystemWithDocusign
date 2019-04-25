package com.nineleaps.DocumentManagementSystem.controller;


import com.nineleaps.DocumentManagementSystem.dto.SigninResponseData;
import com.nineleaps.DocumentManagementSystem.service.Impl.SigninServiceImpl;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@CrossOrigin
public class SignInController {
    @Autowired
    SigninServiceImpl signServiceImpl;


    @ResponseBody

    @GetMapping("/v1/signin")
    public SigninResponseData signInRequest() throws IOException, ParseException {
        System.out.println("SIGNIN:");
        return signServiceImpl.authorizeUser();

    }
}







