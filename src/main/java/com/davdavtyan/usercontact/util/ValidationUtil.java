package com.davdavtyan.usercontact.util;

import com.davdavtyan.usercontact.dto.ContactType;
import com.davdavtyan.usercontact.dto.ValidationDto;
import com.davdavtyan.usercontact.dto.request.ContactRequest;
import com.davdavtyan.usercontact.exception.ApiException;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ValidationUtil {

    public static ValidationDto contactIsValid(ContactRequest contactRequest) throws ApiException {
        if (contactRequest.getContactType().equals(ContactType.EMAIL)
                || contactRequest.getContactType().equals(ContactType.PHONE)) {
            if (!isValidEmail(contactRequest.getName())) {
                return ValidationDto.builder().isValid(false).message("Email not valid " + contactRequest.getName()).build();
            }
            return ValidationDto.builder().isValid(true).message(null).build();
        } else {
            return ValidationDto.builder().isValid(false).message("ContactType not found").build();
        }
    }

    public static boolean isValidEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }


    public static ValidationDto validateContacts(List<ContactRequest> contacts) {
        Optional<ValidationDto> firstInvalidContact = contacts.stream()
                .map(ValidationUtil::contactIsValid)
                .filter(validationDto -> !validationDto.isValid())
                .findFirst();

        return firstInvalidContact.orElseGet(() -> ValidationDto.builder().isValid(true).message(null).build());
    }
}
