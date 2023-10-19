package com.davdavtyan.usercontact.contreoller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.davdavtyan.usercontact.dto.request.ContactRequest;
import com.davdavtyan.usercontact.dto.request.UserRequest;
import com.davdavtyan.usercontact.dto.response.ContactResponse;
import com.davdavtyan.usercontact.dto.response.UserResponse;
import com.davdavtyan.usercontact.entity.Contact;
import com.davdavtyan.usercontact.entity.User;
import com.davdavtyan.usercontact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.getAllUsers().stream()
                .map(this::convertByResponse).collect(Collectors.toList());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userrequest) {
        User user = convertByUser(userrequest);
        UserResponse userResponse = convertByResponse(userService.addUser(user));
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(this::convertByResponse)
                .map(userResponse -> new ResponseEntity<>(userResponse, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private UserResponse convertByResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setContacts(getContacts(user));
        return userResponse;
    }

    private List<ContactResponse> getContacts(User user) {
        return user.getContacts().stream().map(this::convertByContactResponse).collect(Collectors.toList());
    }

    private User convertByUser(UserRequest userrequest) {
        User user = new User();
        user.setName(userrequest.getName());
        user.setContacts(userrequest.getContacts().stream().map(this::convertByContact).collect(Collectors.toList()));
        return user;
    }

    private Contact convertByContact(ContactRequest contactRequest) {
        Contact contact = new Contact();
        contact.setName(contactRequest.getName());
        contact.setContactType(contactRequest.getContactType());
        return contact;
    }

    private ContactResponse convertByContactResponse(Contact contact) {
        ContactResponse contactResponse = new ContactResponse();
        contactResponse.setId(contact.getId());
        contactResponse.setContactType(contact.getContactType());
        contactResponse.setName(contact.getName());
        return contactResponse;
    }
}
