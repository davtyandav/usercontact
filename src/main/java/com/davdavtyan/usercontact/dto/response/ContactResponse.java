package com.davdavtyan.usercontact.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactResponse {

    private Long id;
    private String email;
    private List<String> phones;
}
