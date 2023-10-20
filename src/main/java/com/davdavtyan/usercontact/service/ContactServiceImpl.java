package com.davdavtyan.usercontact.service;

import java.util.List;
import java.util.NoSuchElementException;

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
        return contactRepository.findContactsByUserIdAndContactType(userId, type);
    }

    @Override
    public List<Contact> getContactsByUserId(Long userId) {
        return contactRepository.findByUserId(userId);
    }

    @Override
    public Contact addContactToUser(Long userId, Contact contact) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new NoSuchElementException("User by id %S not found".formatted(userId)));

        contact.setUser(user);
        return contactRepository.save(contact);
    }
}
