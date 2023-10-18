package com.davdavtyan.usercontact.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {

    private Long id;
    private String name;
    private ContactRequest contact;
}
