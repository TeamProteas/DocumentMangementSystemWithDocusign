package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.DeleteServiceImpl;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
public class DeleteController {

    @Autowired
    DeleteServiceImpl deleteServiceImpl;

    @ResponseBody
    @PostMapping("/v1/delete")
    public ResponseEntity<CustomResponse> deleteRequest(@RequestParam("fileType") String fileType, @RequestParam("userId") String userId) throws IOException, ParseException {

        return deleteServiceImpl.deleteRecord(fileType, userId);
    }
}
