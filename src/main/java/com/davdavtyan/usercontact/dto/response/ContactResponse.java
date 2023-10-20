package com.davdavtyan.usercontact.dto.response;

import com.davdavtyan.usercontact.dto.ContactType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record ContactResponse(Long id,  ContactType contactType, String value) {
}
