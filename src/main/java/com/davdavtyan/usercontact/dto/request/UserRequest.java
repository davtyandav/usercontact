package com.davdavtyan.usercontact.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {

    private String name;
    private List<ContactRequest> contacts;
}
