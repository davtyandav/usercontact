package com.davdavtyan.usercontact.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public record UserResponse(Long id, String name, List<ContactResponse> contacts) {
}
