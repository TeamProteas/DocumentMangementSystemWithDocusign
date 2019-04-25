package com.nineleaps.DocumentManagementSystem;

import com.nineleaps.DocumentManagementSystem.exceptions.*;
import com.nineleaps.DocumentManagementSystem.service.ViewService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class DocumentExceptionHandlerTest {

    @InjectMocks
    DocumentExceptionHandler documentExceptionHandler;
    @Mock
    WebRequest webRequest;
    @Mock
    SignInInvalidTokenError signInInvalidTokenError;
    @Mock
    SignInUserDataNotFound signInUserDataNotFound;
    @Mock
    FileTypeEmpty fileTypeEmpty;
    @Mock
    ViewNoRecordsFound viewNoRecordsFound;
    @Mock
    UploadError uploadError;
    @Mock
    NotAllowedToUpload notAllowedToUpload;
    @Mock
    ExceptionHandler exceptionHandler;
    @Test
    public void tokennotfound() {
        ResponseEntity<CustomResponse> responseEntity=documentExceptionHandler.tokenNotFound(signInInvalidTokenError,webRequest);
        assertEquals(responseEntity.getStatusCode().toString(),"401 UNAUTHORIZED");
    }

    @Test
    public void datanotfound() {
        ResponseEntity<CustomResponse> responseEntity=documentExceptionHandler.dataNotFound(signInUserDataNotFound,webRequest);
        assertEquals(responseEntity.getStatusCode().toString(),"403 FORBIDDEN");
    }

    @Test
    public void datanotfound1() {
        ResponseEntity<CustomResponse> responseEntity=documentExceptionHandler.fileEmpty(fileTypeEmpty,webRequest);
        assertEquals(responseEntity.getStatusCode().toString(),"406 NOT_ACCEPTABLE");
    }

    @Test
    public void uploaderror() {
        ResponseEntity<CustomResponse> responseEntity=documentExceptionHandler.noRecordsFound(viewNoRecordsFound,webRequest);
        assertEquals(responseEntity.getStatusCode().toString(),"404 NOT_FOUND");
    }

    @Test
    public void uploaderror1() {
        ResponseEntity<CustomResponse> responseEntity=documentExceptionHandler.uploadError(uploadError,webRequest);
        assertEquals(responseEntity.getStatusCode().toString(),"500 INTERNAL_SERVER_ERROR");
    }

    @Test
    public void uploaderrors() {
        ResponseEntity<CustomResponse> responseEntity=documentExceptionHandler.notAllowedToUpload(notAllowedToUpload,webRequest);
        assertEquals(responseEntity.getStatusCode().toString(),"401 UNAUTHORIZED");
    }

}