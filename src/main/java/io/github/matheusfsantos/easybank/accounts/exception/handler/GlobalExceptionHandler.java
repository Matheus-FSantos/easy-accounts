package io.github.matheusfsantos.easybank.accounts.exception.handler;

import io.github.matheusfsantos.easybank.accounts.dto.ErrorResponseDto;
import io.github.matheusfsantos.easybank.accounts.exception.CustomerAlreadyExistsException;
import io.github.matheusfsantos.easybank.accounts.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException exception, WebRequest webRequest) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorResponseDto(
                    webRequest.getDescription(false),
                    status,
                    exception.getMessage(),
                    LocalDateTime.now()
                ));
    }

    @ExceptionHandler(ResourceNotFoundException .class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        return ResponseEntity
                .status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorResponseDto(
                        webRequest.getDescription(false),
                        status,
                        exception.getMessage(),
                        LocalDateTime.now()
                ));
    }
}
