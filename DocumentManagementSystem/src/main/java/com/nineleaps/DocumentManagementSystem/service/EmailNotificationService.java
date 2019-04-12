package com.nineleaps.DocumentManagementSystem.service;

import com.nineleaps.DocumentManagementSystem.dto.EmailNotificationData;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;

public interface EmailNotificationService {



    public void sendHtmlMail(String To, String templateName, Context context) throws MessagingException;
}