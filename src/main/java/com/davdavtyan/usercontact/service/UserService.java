package com.davdavtyan.usercontact.service;

import java.util.List;
import java.util.Optional;

import com.davdavtyan.usercontact.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    List<User> getAllUsers();

    User addUser(User user);

    Optional<User> getUserById(Long id);
}
