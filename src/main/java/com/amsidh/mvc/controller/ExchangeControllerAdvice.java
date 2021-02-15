package com.amsidh.mvc.controller;

import lombok.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.Serializable;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExchangeControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> runTimeException(Exception ex, WebRequest request) {

        return handleExceptionInternal(ex, new ExceptionModel(ex.getLocalizedMessage(), LocalDateTime.now()),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
class ExceptionModel implements Serializable {
    private String exceptionMessage;
    private LocalDateTime exceptionTime;
}