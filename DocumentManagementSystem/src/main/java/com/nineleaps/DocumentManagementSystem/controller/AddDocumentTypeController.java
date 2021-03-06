package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.AddDocumentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin
public class AddDocumentTypeController {

    @Autowired
    AddDocumentTypeServiceImpl addDocumentTypeService;

    @PostMapping("/v1/doctype/add")
    public ResponseEntity<CustomResponse> getNewDoctype(@RequestParam("fileType") String fileType, @RequestParam("displayName") String displayName) {

        return addDocumentTypeService.addDoctype(fileType, displayName);
    }
}
