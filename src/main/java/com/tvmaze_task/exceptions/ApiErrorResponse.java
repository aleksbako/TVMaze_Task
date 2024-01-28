package com.tvmaze_task.exceptions;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * A model representing an error response returned by an API endpoint.
 */
@Data
public class ApiErrorResponse {
    private final String guid;
    private final String errorCode;
    private final String message;
    private final Integer statusCode;
    private final String statusName;
    private final String path;
    private final String method;
    private final LocalDateTime timestamp;
}