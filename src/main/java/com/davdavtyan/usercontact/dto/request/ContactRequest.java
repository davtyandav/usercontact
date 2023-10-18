package com.davdavtyan.usercontact.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ContactRequest {

    private Long id;
    private List<String> emails;
    private List<String> phones;
}
