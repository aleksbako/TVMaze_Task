package com.tvmaze_task.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class RateLimitExceededException extends RuntimeException {
    private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;

}
