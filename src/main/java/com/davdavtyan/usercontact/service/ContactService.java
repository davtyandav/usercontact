package com.davdavtyan.usercontact.service;

import com.davdavtyan.usercontact.dto.request.ContactRequest;
import com.davdavtyan.usercontact.dto.response.ContactResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
    List<ContactResponse> getContactsByClientAndType(Long clientId, String type);

    ContactResponse addNewContact(ContactRequest contact);
}

