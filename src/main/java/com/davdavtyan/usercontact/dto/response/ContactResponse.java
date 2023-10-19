package com.davdavtyan.usercontact.dto.response;

import com.davdavtyan.usercontact.dto.ContactType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactResponse {

    private Long id;
    private String name;
    private ContactType contactType;
}
