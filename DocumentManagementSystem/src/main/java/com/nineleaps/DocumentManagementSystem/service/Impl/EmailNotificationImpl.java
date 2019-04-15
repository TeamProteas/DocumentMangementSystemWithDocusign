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

    public String sendHtmlMail(String To, String templateName,String name,String description) throws MessagingException ,MailException{
        //set context
        Context context = new Context();
        context.setVariable("title", "REMINDER MAIL");
        context.setVariable("name", name);
        context.setVariable("description",description );

        //process html template
        String body = templateEngine.process(templateName, context);

        // sending mail
        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail, true);
        helper.setTo(To);
        helper.setSubject("html mail");
        helper.setText(body, true);
        javaMailSender.send(mail);

        return " template mail sent";
    }

}

