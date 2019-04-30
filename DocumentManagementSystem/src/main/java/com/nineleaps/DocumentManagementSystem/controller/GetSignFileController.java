package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.GetSignFileImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin
@RestController
public class GetSignFileController {

    @Autowired
    GetSignFileImpl getSignFileImpl;

    @RequestMapping("/v1/getfile")
    public ResponseEntity<CustomResponse> getFile(@RequestParam("name") String name, @RequestParam("documentname") String documentname) throws IOException {
        System.out.println("GETFILE");
        return getSignFileImpl.getFile(name, documentname);

    }
}
