package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.DeleteServiceImpl;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@CrossOrigin
@Controller
public class DeleteController {

    @Autowired
    DeleteServiceImpl deleteServiceImpl;

    @ResponseBody
    @PostMapping("/v1/delete")
    public ResponseEntity<CustomResponse> deleteRequest(@RequestHeader("tokenId") String tokenData, @RequestParam String fileType,@RequestParam String userId) throws IOException, ParseException {
        System.out.println("DELETE:");
            return deleteServiceImpl.deleteRecord(fileType,userId);
    }


}
