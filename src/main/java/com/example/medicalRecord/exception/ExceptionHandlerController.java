package com.example.medicalRecord.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> handleMeidcalRecordException(Exception ex, WebRequest request) {
        return buildResponseEntity(HttpStatus.CONFLICT, "Une erreur est survenue", request);
    }
    private ResponseEntity<Object> buildResponseEntity(HttpStatus status, String message, WebRequest request) {
        CustomErrorResponse errorResponse = CustomErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(message)
                .path(request.getDescription(false).substring(4))
                .build();
        return new ResponseEntity<>(errorResponse, status);
    }

}
@Data
@Builder
class CustomErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
