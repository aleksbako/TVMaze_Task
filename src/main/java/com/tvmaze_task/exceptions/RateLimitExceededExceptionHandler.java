package com.tvmaze_task.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@RestControllerAdvice
public class RateLimitExceededExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RateLimitExceededException.class)
    public ResponseEntity<?> RateLimitExceededException(
            final RateLimitExceededException e, final HttpServletRequest request) {

        var guid = UUID.randomUUID().toString();
        log.error("GUID: " + guid + " - " + e.getMessage(), e);

        var response = new ApiErrorResponse(
                guid,
                e.getErrorCode(),
                e.getMessage(),
                e.getHttpStatus().value(),
                e.getHttpStatus().name(),
                request.getRequestURI(),
                request.getMethod(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, e.getHttpStatus());
    }

}