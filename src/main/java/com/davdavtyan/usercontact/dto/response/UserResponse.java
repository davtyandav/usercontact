package com.davdavtyan.usercontact.dto.responce;

import com.davdavtyan.usercontact.dto.response.ContactResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private ContactResponse contact;
}
