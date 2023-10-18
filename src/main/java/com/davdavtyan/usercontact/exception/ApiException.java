package com.davdavtyan.usercontact.exception;

import com.davdavtyan.usercontact.dto.ExceptionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiException extends RuntimeException {
    private final ExceptionDto exceptionDto;
}