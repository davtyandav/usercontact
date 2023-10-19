package com.davdavtyan.usercontact.service;

import java.util.List;
import java.util.Optional;

import com.davdavtyan.usercontact.dto.ContactType;
import com.davdavtyan.usercontact.dto.ExceptionDto;
import com.davdavtyan.usercontact.entity.Contact;
import com.davdavtyan.usercontact.entity.User;
import com.davdavtyan.usercontact.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);
    private final ContactRepository contactRepository;
    private final UserRepository userRepository;

    public ContactServiceImpl(ContactRepository contactRepository, UserRepository userRepository) {
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Contact> getContactsByUserIdAndType(Long userId, ContactType type) {
        return contactRepository.getContactsByUserAndContactType(userId, type);
    }

    @Override
    public List<Contact> getContactsByUserId(Long userId) {
        return contactRepository.findByUserId(userId);
    }

    @Override
    public Contact addContactByUser(Long userId, Contact contact) {
        Optional<User> userById = userRepository.findById(userId);

        if(userById.isEmpty()){
            LOGGER.error("Error has occurred during getting user: UserId = " + userId);
            throw userNotFoundException();
        }
        contact.setUser(userById.get());
        return contactRepository.save(contact);
    }

    private static ApiException noteNotFoundException() {
        ExceptionDto exceptionDto = ExceptionDto.builder()
                .message("Note Not Found")
                .status(HttpStatus.NOT_FOUND)
                .build();
        throw new ApiException(exceptionDto);
    }

    private static ApiException userNotFoundException() {
        ExceptionDto exceptionDto = ExceptionDto.builder()
                .message("User Not Found")
                .status(HttpStatus.NOT_FOUND)
                .build();
        throw new ApiException(exceptionDto);
    }

}
