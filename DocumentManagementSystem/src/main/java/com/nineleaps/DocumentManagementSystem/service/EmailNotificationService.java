package com.nineleaps.DocumentManagementSystem.service;

import javax.mail.MessagingException;

public interface EmailNotificationService {


    public String sendHtmlMail(String To, String templateName, String name, String description) throws MessagingException;
}