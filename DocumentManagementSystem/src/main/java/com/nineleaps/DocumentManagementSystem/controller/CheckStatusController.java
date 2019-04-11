package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.service.Impl.CheckStatusImpl;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
public class CheckStatusController {

    @Autowired
    CheckStatusImpl checkStatusImpl;

    @RequestMapping("/v1/chkstatus")
    public String status(@RequestHeader("tokenId") String tokenData, @RequestParam("name")String name, @RequestParam("documentname")String documentname) throws IOException, ParseException {
        return checkStatusImpl.checkStatus(name,documentname);
    }
}

