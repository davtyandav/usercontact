package com.davdavtyan.usercontact.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UserRequest(@NotNull String name, @Valid List<ContactRequest> contacts) {
}
