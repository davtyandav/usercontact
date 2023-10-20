package com.davdavtyan.usercontact.dto.response;

import java.util.List;

public record UserResponse(Long id, String name, List<ContactResponse> contacts) {
}
