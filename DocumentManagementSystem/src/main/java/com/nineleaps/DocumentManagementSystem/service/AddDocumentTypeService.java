package com.nineleaps.DocumentManagementSystem.service;

import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import org.springframework.http.ResponseEntity;

public interface AddDocumentTypeService {

    public ResponseEntity<CustomResponse> addDoctype(String tokenData, String fileType, String displayName);
}
