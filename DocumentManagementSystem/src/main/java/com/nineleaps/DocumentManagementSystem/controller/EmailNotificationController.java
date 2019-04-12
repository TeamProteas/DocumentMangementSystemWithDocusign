package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.dto.EmailNotificationData;
import com.nineleaps.DocumentManagementSystem.service.Impl.EmailNotificationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;

@CrossOrigin
@RestController
public class EmailNotificationController {

    @Autowired
    EmailNotificationImpl notificationImpl;



    @RequestMapping("/v1/sendhtml")
    public String htmlMail(@RequestHeader("tokenId") String tokenId, @RequestBody EmailNotificationData emailNotificationData) {
        Context context = new Context();
        context.setVariable("title", "REMINDER MAIL");
        context.setVariable("name", emailNotificationData.getName());
        context.setVariable("description", emailNotificationData.getDescription());
        try {
            notificationImpl.sendHtmlMail(emailNotificationData.getEmailAddress(), "template", context);
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        }
        return "html mail sent";
    }
}
