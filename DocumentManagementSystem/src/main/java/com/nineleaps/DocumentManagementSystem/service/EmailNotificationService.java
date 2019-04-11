package com.nineleaps.DocumentManagementSystem.service;

import com.nineleaps.DocumentManagementSystem.dto.EmailNotificationData;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;

public interface EmailNotificationService {

    public void sendNotification(EmailNotificationData emailNotificationData);

    public void sendHtmlMail(String To, String templateName, Context context) throws MessagingException;
}