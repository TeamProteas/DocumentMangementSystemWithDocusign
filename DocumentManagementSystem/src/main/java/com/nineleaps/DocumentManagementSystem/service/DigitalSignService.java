package com.nineleaps.DocumentManagementSystem.service;

import org.json.simple.parser.ParseException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DigitalSignService {

    public void sendSignRequest(String signeeEmailid, String signeeName, String name, MultipartFile file, String documentName) throws IOException, ParseException;
}