package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.service.DownloadService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
@CrossOrigin
public class DownloadController {

    @Autowired
    DownloadService downloadServiceImpl;

    @GetMapping(value="/v1/download")
    public ResponseEntity<Object> DownloadFile(@RequestHeader("tokenId") String tokenData , @RequestParam("file") String fileType) throws IOException, ParseException {
        System.out.println("DOWNLOAD:");
        return downloadServiceImpl.giveFile(fileType);

    }
}
