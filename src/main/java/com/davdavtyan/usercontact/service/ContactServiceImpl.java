package com.davdavtyan.usercontact.service;

import com.davdavtyan.usercontact.dto.request.ContactRequest;
import com.davdavtyan.usercontact.dto.response.ContactResponse;
import com.davdavtyan.usercontact.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<ContactResponse> getContactsByClientAndType(Long clientId, String type) {
//        return convert(contactRepository.findByUserAndIdAndContactType(clientId, type));

        return null;
    }

    @Override
    public ContactResponse addNewContact(ContactRequest contact) {
        return null;
    }

    private List<ContactResponse> convert(List<Contact> contacts) {
        return null;
    }
}
