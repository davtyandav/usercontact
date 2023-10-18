package com.davdavtyan.usercontact.service;

import com.davdavtyan.usercontact.dto.request.UserRequest;
import org.springframework.stereotype.Service;
import com.davdavtyan.usercontact.dto.responce.UserResponse;

import java.util.List;

@Service
public interface UserService {
    List<UserResponse> getAllUsers();

    UserResponse addUser(UserRequest user);

    UserResponse getUserById(Long id);
}
