
package com.example.demo.present.controller;

import com.example.demo.dto.errResource;
import com.example.demo.exception.AppException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class exceptionController {

    private static final Logger logger = LoggerFactory.getLogger(exceptionController.class);


    @ExceptionHandler(AppException.class)
    public ResponseEntity<errResource> handleException(AppException ex) {
        errResource err = new errResource(ex.getHttpStatus().value(), ex.getMessage());
        return ResponseEntity.status(ex.getHttpStatus()).body(err);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public errResource handlerValidationException(ValidationException ex, WebRequest request) {
        String uuid = MDC.get("request_id");
        logger.warn("id: {}, msg: {}, request description: {}", uuid, ex.getMessage(), request.getDescription(false));
//        ex.printStackTrace();
        return new errResource(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public errResource handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        String uuid = MDC.get("request_id");
        logger.warn("id: {}, msg: {}, request description: {}", uuid, ex.getMessage(), request.getDescription(false));
//        ex.printStackTrace();
        logger.info(ex.getMessage());
        return new errResource(HttpStatus.BAD_REQUEST.value(), "invalid request");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public errResource handleConstraintViolationException(MethodArgumentNotValidException ex, WebRequest request) {
        String uuid = MDC.get("request_id");
        logger.warn("id: {}, msg: {}, request description: {}", uuid, ex.getMessage(), request.getDescription(false));
//        ex.printStackTrace();
        return new errResource(HttpStatus.BAD_REQUEST.value(), "invalid request");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public errResource handleMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, WebRequest request) {
        String uuid = MDC.get("request_id");
        logger.warn("id: {}, msg: {}, request description: {}", uuid, ex.getMessage(), request.getDescription(false));
//        ex.printStackTrace();
        return new errResource(HttpStatus.NOT_FOUND.value(), "method not support");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public errResource handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {
        String uuid = MDC.get("request_id");
        logger.warn("id: {}, msg: {}, request description: {}", uuid, ex.getMessage(), request.getDescription(false));
//        ex.printStackTrace();
        return new errResource(HttpStatus.BAD_REQUEST.value(), "message not readable");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public errResource globalExceptionHandler(Exception ex, WebRequest request) {
        String uuid = MDC.get("request_id");
        logger.error("id: {}, msg: {}, request description: {}", uuid, ex.getMessage(), request.getDescription(false));
        ex.printStackTrace();
        return new errResource(HttpStatus.INTERNAL_SERVER_ERROR.value(), "system error");
    }

}
