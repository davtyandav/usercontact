package com.davdavtyan.usercontact.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ValidationDto {
    private final boolean isValid;
    private final String message;
}
