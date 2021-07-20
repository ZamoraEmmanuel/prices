package net.zamora.error.controller;

import net.zamora.error.controller.dto.ApiErrorMessage;
import net.zamora.exceptions.NotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorMessage> notFound(NotFoundException ex) {
        return new ResponseEntity<>(new ApiErrorMessage(ex.messageId, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

}
