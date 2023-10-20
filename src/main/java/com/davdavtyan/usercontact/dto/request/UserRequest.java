package com.davdavtyan.usercontact.dto.request;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record UserRequest(@NotNull String name, @Valid List<ContactRequest> contacts) {
}
