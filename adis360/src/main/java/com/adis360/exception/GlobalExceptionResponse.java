package com.adis360.exception;

import java.time.LocalDateTime;

public record GlobalExceptionResponse(
        String message,
        LocalDateTime timeStamp,
        int status
) {
}
