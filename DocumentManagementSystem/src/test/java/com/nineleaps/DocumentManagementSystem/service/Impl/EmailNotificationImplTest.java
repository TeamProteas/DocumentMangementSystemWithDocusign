package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.extension.listener.AnnotationEnabler;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockListener;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.*;

@PowerMockListener(AnnotationEnabler.class)
@PrepareForTest({EmailNotificationImpl.class, Context.class,TemplateEngine.class})
@RunWith(PowerMockRunner.class)
public class EmailNotificationImplTest {

    @InjectMocks
    EmailNotificationImpl emailNotification;

    @Mock
    TemplateEngine templateEngine;
    @Mock
    JavaMailSender mailSender;


    @Test
    public void sendHtmlMail() throws Exception {
        Context context = mock(Context.class);
        whenNew(Context.class).withAnyArguments().thenReturn(context);

            TemplateEngine templateEngine=PowerMockito.mock(TemplateEngine.class,Mockito.RETURNS_MOCKS);


       PowerMockito.when(templateEngine.process(anyString(),any())).thenReturn("sjhhsd");
       MimeMessageHelper mimeMessageHelper=mock(MimeMessageHelper.class);
       whenNew(MimeMessageHelper.class).withAnyArguments().thenReturn(mimeMessageHelper);



        ResponseEntity<CustomResponse> responseEntity = emailNotification.sendHtmlMail("anmol", "template", "mukul", "cde");
        assertEquals(responseEntity.getStatusCode().getReasonPhrase(), "OK");
    }
}