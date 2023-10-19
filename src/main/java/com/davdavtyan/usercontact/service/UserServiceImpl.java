package com.davdavtyan.usercontact.service;

import java.util.List;
import java.util.Optional;

import com.davdavtyan.usercontact.entity.Contact;
import com.davdavtyan.usercontact.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ContactRepository contactRepository;

    public UserServiceImpl(UserRepository userRepository, ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        User savedUser = userRepository.save(user);
        for (Contact contact : savedUser.getContacts()) {
            contact.setUser(savedUser);
        }
        contactRepository.saveAll(savedUser.getContacts());
        return user;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);

    }
}
