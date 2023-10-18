package com.davdavtyan.usercontact.dto.request;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactRequest {

    private Long id;
    private List<String> emails;
    private List<String> phones;
}
