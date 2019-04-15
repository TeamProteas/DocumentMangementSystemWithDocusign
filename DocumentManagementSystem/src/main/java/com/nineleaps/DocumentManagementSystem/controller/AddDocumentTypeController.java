package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.AddDocumentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddDocumentTypeController {
    @Autowired
    AddDocumentTypeServiceImpl addDocumentTypeService;


@PostMapping("/v1/doctype/add")
public ResponseEntity<CustomResponse> getNewDoctype(@RequestHeader("tokenId") String tokenData, @RequestParam("fileType") String fileType, @RequestParam("displayName") String displayName) {

    return addDocumentTypeService.addDoctype(fileType, displayName);


}


}
