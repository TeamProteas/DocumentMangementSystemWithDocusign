package com.nineleaps.DocumentManagementSystem.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public interface DownloadService {

    ResponseEntity<Object> giveFile(String fileType) throws FileNotFoundException;
}
