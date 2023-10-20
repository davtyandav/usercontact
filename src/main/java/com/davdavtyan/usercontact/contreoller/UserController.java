package com.davdavtyan.usercontact.contreoller;

import java.util.List;
import java.util.stream.Collectors;

import com.davdavtyan.usercontact.dto.request.ContactRequest;
import com.davdavtyan.usercontact.dto.request.UserRequest;
import com.davdavtyan.usercontact.dto.response.ContactResponse;
import com.davdavtyan.usercontact.dto.response.UserResponse;
import com.davdavtyan.usercontact.entity.Contact;
import com.davdavtyan.usercontact.entity.User;
import com.davdavtyan.usercontact.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers().stream()
            .map(this::convertToResponse)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
            .map(this::convertToResponse)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserResponse addUser(@RequestBody @Valid UserRequest userRequest) {
        User user = userService.addUser(convertUser(userRequest));
        return convertToResponse(user);
    }

    private UserResponse convertToResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), convertContacts(user.getContacts()));
    }

    private List<ContactResponse> convertContacts(List<Contact> contacts) {
        return contacts.stream().map(this::convertByContactResponse).collect(Collectors.toList());
    }

    private User convertUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.name());
        user.setContacts(userRequest.contacts().stream().map(this::convertContact).collect(Collectors.toList()));
        return user;
    }

    private Contact convertContact(ContactRequest contactRequest) {
        Contact contact = new Contact();
        contact.setValue(contactRequest.value());
        contact.setContactType(contactRequest.contactType());
        return contact;
    }

    private ContactResponse convertByContactResponse(Contact contact) {
        return new ContactResponse(contact.getId(), contact.getContactType(), contact.getValue());
    }
}
