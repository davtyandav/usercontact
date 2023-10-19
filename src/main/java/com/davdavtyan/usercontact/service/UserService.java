package com.davdavtyan.usercontact.service;

import java.util.List;

import com.davdavtyan.usercontact.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    List<User> getAllUsers();

    User addUser(User user);

    User getUserById(Long id);
}
