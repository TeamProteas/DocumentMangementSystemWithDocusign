package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.dto.EmailNotificationData;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.service.Impl.EmailNotificationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@CrossOrigin
@RestController
public class EmailNotificationController {

    @Autowired
    EmailNotificationImpl notificationImpl;


    @PostMapping("/v1/sendhtml")
    public ResponseEntity<CustomResponse> htmlMail(@RequestBody EmailNotificationData emailNotificationData) throws MessagingException {

        return notificationImpl.sendHtmlMail(emailNotificationData.getEmailAddress(), "template", emailNotificationData.getName(), emailNotificationData.getDescription());

    }
}
