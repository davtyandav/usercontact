package com.davdavtyan.usercontact.contreoller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.davdavtyan.usercontact.dto.ContactType;
import com.davdavtyan.usercontact.dto.request.ContactRequest;
import com.davdavtyan.usercontact.dto.response.ContactResponse;
import com.davdavtyan.usercontact.entity.Contact;
import com.davdavtyan.usercontact.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/{userId}/contacts")
@Validated
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<ContactResponse> getContactsByUserIdAndType(@PathVariable Long userId,
                                                            @RequestParam(required = false) ContactType type) {
        List<Contact> contacts = type == null
            ? contactService.getContactsByUserId(userId)
            : contactService.getContactsByUserIdAndType(userId, type);

        return contacts.stream()
            .map(this::convertToContactResponse)
            .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<?> addContact(@PathVariable Long userId,
                                        @RequestBody @Valid ContactRequest contactRequest) {
        Contact contact = convertToContact(contactRequest);

        Contact savedContact;
        try {
            savedContact = contactService.addContactToUser(userId, contact);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok(convertToContactResponse(savedContact));
    }

    private Contact convertToContact(ContactRequest contactRequest) {
        Contact contact = new Contact();
        contact.setContactType(contactRequest.contactType());
        contact.setValue(contactRequest.value());
        return contact;
    }

    private ContactResponse convertToContactResponse(Contact contact) {
        return new ContactResponse(contact.getId(), contact.getContactType(), contact.getValue());
    }
}