package com.nineleaps.DocumentManagementSystem.service;

import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface CheckStatusService {
    public ResponseEntity<CustomResponse> checkStatus(String name, String documentname) throws IOException, ParseException;
}