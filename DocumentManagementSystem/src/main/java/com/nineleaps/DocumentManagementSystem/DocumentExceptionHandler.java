package com.nineleaps.DocumentManagementSystem;

import com.nineleaps.DocumentManagementSystem.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
public class DocumentExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SignInInvalidTokenError.class)
    public final ResponseEntity<CustomResponse> tokenNotFound(SignInInvalidTokenError ex, WebRequest request) {
        CustomResponse customResponse = new CustomResponse(new Date(), ex.getMessage(),
                request.getDescription(false), HttpStatus.UNAUTHORIZED.getReasonPhrase());
        return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(SignInUserDataNotFound.class)
    public final ResponseEntity<CustomResponse> dataNotFound(SignInUserDataNotFound ex, WebRequest webRequest) {
        CustomResponse customResponse = new CustomResponse(new Date(), ex.getMessage(), webRequest.
                getDescription(false), HttpStatus.FORBIDDEN.getReasonPhrase());
        return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NotAllowedToUpload.class)
    public final ResponseEntity<CustomResponse> notAllowedToUpload(NotAllowedToUpload ex, WebRequest webRequest) {
        CustomResponse customResponse = new CustomResponse(new Date(), ex.getMessage(), webRequest.
                getDescription(false), HttpStatus.UNAUTHORIZED.getReasonPhrase());
        return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.UNAUTHORIZED);


    }


    @ExceptionHandler(ViewNoRecordsFound.class)
    public final ResponseEntity<CustomResponse> noRecordsFound(ViewNoRecordsFound ex, WebRequest webRequest) {
        CustomResponse customResponse = new CustomResponse(new Date(), ex.getMessage(), webRequest.
                getDescription(false), HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(UploadError.class)
    public final ResponseEntity<CustomResponse> uploadError(UploadError ex, WebRequest webRequest) {
        CustomResponse customResponse = new CustomResponse(new Date(), ex.getMessage(), webRequest.
                getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(FileTypeEmpty.class)
    public final ResponseEntity<CustomResponse> fileEmpty(FileTypeEmpty ex, WebRequest webRequest) {
        CustomResponse customResponse = new CustomResponse(new Date(), ex.getMessage(), webRequest.
                getDescription(false), HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
        return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NOT_ACCEPTABLE);

    }
}








