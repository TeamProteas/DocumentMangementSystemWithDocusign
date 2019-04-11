package com.nineleaps.DocumentManagementSystem.service;


import com.nineleaps.DocumentManagementSystem.dto.SigninResponseData;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service

public interface SignInService {
    public SigninResponseData authorizeUser();




}
