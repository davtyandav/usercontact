package com.davdavtyan.usercontact.contreoller;

import java.util.List;

import com.davdavtyan.usercontact.exception.ApiError;
import com.davdavtyan.usercontact.exception.ApiError.ApiErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();

        List<ApiErrorDetails> details = fieldErrors.stream()
            .map(error -> new ApiErrorDetails(error.getCode(), error.getField(), error.getDefaultMessage()))
            .toList();

        var apiError = new ApiError("Validation failed", details);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
}