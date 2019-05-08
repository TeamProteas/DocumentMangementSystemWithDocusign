package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.DocumentType;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.repository.DocumentTypeRepository;
import com.nineleaps.DocumentManagementSystem.service.AddDocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class AddDocumentTypeServiceImpl implements AddDocumentTypeService {
    @Autowired
    DocumentTypeRepository documentTypeRepository;

    @Override
    public ResponseEntity<CustomResponse> addDoctype(String fileType, String displayName) {

        documentTypeRepository.save(new DocumentType(UUID.randomUUID(), displayName, fileType));
        CustomResponse customResponse = new CustomResponse(new Date(), "Type Uploaded Sucesssfully", "the changes are made to the database", HttpStatus.OK.getReasonPhrase());

        return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.OK);
    }
}
