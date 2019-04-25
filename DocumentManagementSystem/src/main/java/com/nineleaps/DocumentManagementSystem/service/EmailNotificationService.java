package com.nineleaps.DocumentManagementSystem.service;

import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import org.springframework.http.ResponseEntity;

import javax.mail.MessagingException;

public interface EmailNotificationService {


    public ResponseEntity<CustomResponse> sendHtmlMail(String To, String templateName, String name, String description) throws MessagingException;
}