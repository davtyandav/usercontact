package com.davdavtyan.usercontact.service;

import java.util.List;

import com.davdavtyan.usercontact.dto.ContactType;
import com.davdavtyan.usercontact.entity.Contact;
import org.springframework.stereotype.Service;

@Service
public interface ContactService {
    List<Contact> getContactsByUserIdAndType(Long userId, ContactType type);

    List<Contact> getContactsByUserId(Long userId);

    Contact addContactByUser(Long userId, Contact contact);
}

