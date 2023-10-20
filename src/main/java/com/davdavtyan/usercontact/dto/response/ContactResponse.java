package com.davdavtyan.usercontact.dto.response;

import com.davdavtyan.usercontact.dto.ContactType;

public record ContactResponse(Long id, ContactType contactType, String value) {
}
