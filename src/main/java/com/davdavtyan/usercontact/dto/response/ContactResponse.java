package com.davdavtyan.usercontact.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ContactResponse {

    private Long id;
    private List<String> emails;
    private List<String> phones;
}
