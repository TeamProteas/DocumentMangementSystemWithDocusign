package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dto.EmailNotificationData;
import com.nineleaps.DocumentManagementSystem.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class EmailNotificationImpl implements EmailNotificationService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    public void sendNotification(EmailNotificationData emailNotificationData) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(emailNotificationData.getEmailAddress());
        mail.setSubject("new mail");
        mail.setText("hello there");
        javaMailSender.send(mail);
    }

    public void sendHtmlMail(String To, String templateName, Context context) throws MessagingException {
        MimeMessage mail = javaMailSender.createMimeMessage();
        String body = templateEngine.process(templateName, context);
        MimeMessageHelper helper = new MimeMessageHelper(mail, true);
        helper.setTo(To);
        helper.setSubject("html mail");
        helper.setText(body, true);
        javaMailSender.send(mail);


    }

}

