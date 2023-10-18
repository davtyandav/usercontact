package com.davdavtyan.usercontact.service;

import com.davdavtyan.usercontact.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
    List<Contact> getContactsByUserIdAndType(Long userId, String type);
    List<Contact> getContactsByUserId(Long userId);

    Contact addContactByUser(Long userId, Contact contact);
}

