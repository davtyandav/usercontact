package com.davdavtyan.usercontact.contreoller;

import java.util.List;
import java.util.stream.Collectors;

import com.davdavtyan.usercontact.dto.ContactType;
import com.davdavtyan.usercontact.dto.request.ContactRequest;
import com.davdavtyan.usercontact.dto.request.UserRequest;
import com.davdavtyan.usercontact.dto.response.ContactResponse;
import com.davdavtyan.usercontact.dto.response.UserResponse;
import com.davdavtyan.usercontact.entity.Contact;
import com.davdavtyan.usercontact.entity.User;
import com.davdavtyan.usercontact.service.ContactService;
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
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/user/{userId}/type/{type}")
    public ResponseEntity<List<ContactResponse>> getContactsByUserIdAndType(@PathVariable Long userId,
                                                                            @PathVariable ContactType type) {
        List<ContactResponse> contacts =
            contactService.getContactsByUserIdAndType(userId, type).stream().map(this::convertByContactResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ContactResponse>> getContactsByUserId(@PathVariable Long userId) {
        List<ContactResponse> contacts =
            contactService.getContactsByUserId(userId).stream().map(this::convertByContactResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<ContactResponse> addContact(@PathVariable Long userId,
                                                      @RequestBody ContactRequest contactRequest) {
        Contact contact = convertByContact(contactRequest);
        ContactResponse contactResponse = convertByContactResponse(contactService.addContactByUser(userId, contact));
        return new ResponseEntity<>(contactResponse, HttpStatus.OK);
    }

    private Contact convertByContact(ContactRequest contactRequest) {
        Contact contact = new Contact();
        contact.setContactType(contactRequest.getContactType());
        contact.setName(contactRequest.getName());
        return contact;
    }

    private ContactResponse convertByContactResponse(Contact contact) {
        ContactResponse contactResponse = new ContactResponse();
        contactResponse.setId(contact.getId());
        contactResponse.setContactType(contact.getContactType());
        contactResponse.setName(contact.getName());
        return contactResponse;
    }

    private UserResponse convertByResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());

        return userResponse;
    }
}