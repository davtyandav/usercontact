package com.davdavtyan.usercontact.contreoller;

import com.davdavtyan.usercontact.dto.request.ContactRequest;
import com.davdavtyan.usercontact.dto.response.ContactResponse;
import com.davdavtyan.usercontact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/client/{clientId}/type/{type}")
    public List<ContactResponse> getContactsByClientAndType(@PathVariable Long clientId, @PathVariable String type) {
        return contactService.getContactsByClientAndType(clientId, type);
    }

    @PostMapping
    public ContactResponse addNewContact(@RequestBody ContactRequest contact) {
        return contactService.addNewContact(contact);
    }
}