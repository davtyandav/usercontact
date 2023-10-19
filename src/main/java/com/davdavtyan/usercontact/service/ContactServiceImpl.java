package com.davdavtyan.usercontact.service;

import java.util.List;

import com.davdavtyan.usercontact.dto.ContactType;
import com.davdavtyan.usercontact.entity.Contact;
import com.davdavtyan.usercontact.entity.User;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final UserRepository userRepository;

    public ContactServiceImpl(ContactRepository contactRepository, UserRepository userRepository) {
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Contact> getContactsByUserIdAndType(Long userId, ContactType type) {
        return contactRepository.findContactsByUser_IdAndContactType(userId, type);
    }

    @Override
    public List<Contact> getContactsByUserId(Long userId) {
        return contactRepository.findByUserId(userId);
    }

    @Override
    public Contact addContactByUser(Long userId, Contact contact) {
        User byId = userRepository.findById(userId).get();
        contact.setUser(byId);
        return contactRepository.save(contact);
    }

}
