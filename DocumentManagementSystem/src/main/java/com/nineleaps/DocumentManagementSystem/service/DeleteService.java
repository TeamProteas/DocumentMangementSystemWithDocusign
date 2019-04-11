package com.nineleaps.DocumentManagementSystem.service;

import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DeleteService {

    public ResponseEntity<CustomResponse> deleteRecord(String fileType,String userId);
}
