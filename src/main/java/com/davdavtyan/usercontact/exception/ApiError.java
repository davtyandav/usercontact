package com.davdavtyan.usercontact.exception;

import java.util.List;

public record ApiError(String message, List<ApiErrorDetails> details) {

    public record ApiErrorDetails(String code, String path, String message) {
    }
}