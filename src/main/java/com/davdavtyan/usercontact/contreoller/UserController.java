package com.davdavtyan.usercontact.contreoller;

import com.davdavtyan.usercontact.dto.request.UserRequest;
import com.davdavtyan.usercontact.service.UserService;
import com.davdavtyan.usercontact.dto.responce.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserResponse addUser(@RequestBody UserRequest user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
