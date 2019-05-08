package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.dao.DocumentType;
import com.nineleaps.DocumentManagementSystem.service.Impl.DocumentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class DocumentTypeController {

    @Autowired
    DocumentTypeServiceImpl documentTypeServiceImpl;

    @ResponseBody
    @GetMapping("/v1/doctype")
    public List<DocumentType> getTypes() {

        return documentTypeServiceImpl.fetchTypeOfDocument();
    }
}
