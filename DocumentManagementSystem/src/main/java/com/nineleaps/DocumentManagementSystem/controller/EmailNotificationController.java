package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.dto.EmailNotificationData;
import com.nineleaps.DocumentManagementSystem.service.Impl.EmailNotificationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@CrossOrigin
@RestController
public class EmailNotificationController {

    @Autowired
    EmailNotificationImpl notificationImpl;


    @GetMapping("/v1/sendhtml")
    public String htmlMail(@RequestBody EmailNotificationData emailNotificationData) throws MessagingException {

        return notificationImpl.sendHtmlMail(emailNotificationData.getEmailAddress(), "template",emailNotificationData.getName(),emailNotificationData.getDescription());

    }
}
