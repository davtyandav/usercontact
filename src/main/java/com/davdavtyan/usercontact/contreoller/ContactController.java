package com.davdavtyan.usercontact.contreoller;

import com.davdavtyan.usercontact.dto.ContactType;
import com.davdavtyan.usercontact.dto.ValidationDto;
import com.davdavtyan.usercontact.dto.request.ContactRequest;
import com.davdavtyan.usercontact.dto.response.ContactResponse;
import com.davdavtyan.usercontact.entity.Contact;
import com.davdavtyan.usercontact.service.ContactService;
import com.davdavtyan.usercontact.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<?> addContact(@PathVariable Long userId,
                                        @RequestBody ContactRequest contactRequest) {

        ValidationDto validationDto = ValidationUtil.contactIsValid(contactRequest);
        if (validationDto.isValid()) {
            Contact contact = convertByContact(contactRequest);
            ContactResponse contactResponse = convertByContactResponse(contactService.addContactByUser(userId, contact));
            return new ResponseEntity<>(contactResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(validationDto.getMessage(), HttpStatus.FORBIDDEN);
        }
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
}