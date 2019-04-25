package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.extension.listener.AnnotationEnabler;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockListener;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@PowerMockListener(AnnotationEnabler.class)
@PrepareForTest({EmailNotificationImpl.class, Context.class})
@RunWith(PowerMockRunner.class)
public class EmailNotificationImplTest {

    @InjectMocks
    EmailNotificationImpl emailNotification;

    @Mock
    JavaMailSender javaMailSender;
    @Mock
    MimeMessage mimeMessage;
    @Mock
    TemplateEngine templateEngine;
    @Mock
    Context context;
    @Mock
    RabbitProperties.Template template;


    @Test

    public void sendHtmlMail() throws Exception {

   when(templateEngine.process("template",context)).thenReturn("kldjfdksdlhfkjfdhdhfdf");

        ResponseEntity<CustomResponse> responseEntity = emailNotification.sendHtmlMail("anmol", "template", "mukul", "cde");
        assertEquals(responseEntity.getStatusCode().getReasonPhrase(), "OK");
    }
}