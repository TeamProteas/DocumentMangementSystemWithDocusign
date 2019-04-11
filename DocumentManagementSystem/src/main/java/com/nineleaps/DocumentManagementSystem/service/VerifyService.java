package com.nineleaps.DocumentManagementSystem.service;

import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import org.springframework.http.ResponseEntity;

public interface VerifyService {

    public ResponseEntity<CustomResponse> changeVerifyStatus(String userId, String fileType);
}
