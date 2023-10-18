package com.davdavtyan.usercontact.service;

import com.davdavtyan.usercontact.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> getContactsByUserIdAndType(Long userId, String type) {

        return null;
    }

    @Override
    public List<Contact> getContactsByUserId(Long userId) {

        return null;
    }

    @Override
    public Contact addContactByUser(Long userId, Contact contact) {
        return null;
    }

}
