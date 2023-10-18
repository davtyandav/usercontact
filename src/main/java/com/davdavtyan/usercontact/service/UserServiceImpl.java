package com.davdavtyan.usercontact.service;

import com.davdavtyan.usercontact.dto.request.UserRequest;
import com.davdavtyan.usercontact.dto.responce.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class UserServiceImpl implements UserService{
    @Override
    public List<UserResponse> getAllUsers() {
        return null;
    }

    @Override
    public UserResponse addUser(UserRequest user) {
        return null;
    }

    @Override
    public UserResponse getUserById(Long id) {
        return null;
    }
}
