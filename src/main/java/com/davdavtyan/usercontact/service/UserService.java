package com.davdavtyan.usercontact.service;

import com.davdavtyan.usercontact.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();

    User addUser(User user);

    User getUserById(Long id);
}
