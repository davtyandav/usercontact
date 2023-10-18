package com.davdavtyan.usercontact.contreoller;

import com.davdavtyan.usercontact.dto.request.UserRequest;
import com.davdavtyan.usercontact.dto.response.UserResponse;
import com.davdavtyan.usercontact.entity.User;
import com.davdavtyan.usercontact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        return userService.getAllUsers().stream()
                .map(this::convertByResponse).collect(Collectors.toList());
    }

    @PostMapping
    public UserResponse addUser(@RequestBody UserRequest userrequest) {
        User user = convertByUser(userrequest);
        return convertByResponse(userService.addUser(user));
    }


    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return convertByResponse(userService.getUserById(id));
    }


    private UserResponse convertByResponse(User user) {
        return null;
    }

    private User convertByUser(UserRequest userrequest) {
        return null;
    }
}
