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
    private String email;
    private List<String> phones;
}
