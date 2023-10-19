package com.davdavtyan.usercontact.dto.request;

import com.davdavtyan.usercontact.dto.ContactType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactRequest {

    private Long id;
    private String name;
    private ContactType contactType;
    private Long userId;

}
