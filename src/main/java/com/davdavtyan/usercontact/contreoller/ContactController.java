package com.davdavtyan.usercontact.contreoller;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/client/{clientId}/type/{type}")
    public List<Contact> getContactsByClientAndType(@PathVariable Long clientId, @PathVariable String type) {
        Client client = new Client();
        client.setId(clientId);
        return contactService.getContactsByClientAndType(client, type);
    }

    @PostMapping
    public Contact addNewContact(@RequestBody Contact contact) {
        return contactService.addNewContact(contact);
    }
}