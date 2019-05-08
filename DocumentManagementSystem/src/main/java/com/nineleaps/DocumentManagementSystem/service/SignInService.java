package com.nineleaps.DocumentManagementSystem.service;


import com.nineleaps.DocumentManagementSystem.dto.SigninResponseData;
import org.springframework.stereotype.Service;

@Service
public interface SignInService {
    public SigninResponseData authorizeUser();
}
