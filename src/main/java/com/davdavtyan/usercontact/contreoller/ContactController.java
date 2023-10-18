package com.davdavtyan.usercontact.contreoller;

import com.davdavtyan.usercontact.dto.request.ContactRequest;
import com.davdavtyan.usercontact.dto.response.ContactResponse;
import com.davdavtyan.usercontact.entity.Contact;
import com.davdavtyan.usercontact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ContactResponse> getContactsByUserIdAndType(@PathVariable Long userId, @PathVariable String type) {
        return contactService.getContactsByUserIdAndType(userId, type).stream().map(this::convertByResponse).collect(Collectors.toList());
    }

    @GetMapping("/user/{userId}")
    public List<ContactResponse> getContactsByUserId(@PathVariable Long userId) {
        return contactService.getContactsByUserId(userId).stream().map(this::convertByResponse).collect(Collectors.toList());
    }

    @GetMapping("/user/{userId}")
    public ContactResponse addContact(@PathVariable Long userId, @RequestBody ContactRequest contactRequest) {

        Contact contact = convertByEntity(contactRequest);
        return convertByResponse(contactService.addContactByUser(userId, contact));
    }

    private ContactResponse convertByResponse(Contact contact) {
        return null;
    }

    private Contact convertByEntity(ContactRequest contactRequest) {
        return null;
    }
}