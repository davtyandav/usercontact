package com.davdavtyan.usercontact.dto.request;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {

    private String name;
    private List<ContactRequest> contacts;
}
