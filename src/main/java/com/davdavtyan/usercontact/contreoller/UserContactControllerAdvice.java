package com.davdavtyan.usercontact.contreoller;

import java.util.stream.Collectors;

import com.davdavtyan.usercontact.dto.ExceptionDto;
import com.davdavtyan.usercontact.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserContactControllerAdvice {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException apiException) {
        ExceptionDto exceptionDto = apiException.getExceptionDto();
        return ResponseEntity.status(exceptionDto.getStatus()).body(exceptionDto);
    }


}