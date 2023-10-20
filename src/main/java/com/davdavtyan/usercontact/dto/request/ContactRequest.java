package com.davdavtyan.usercontact.dto.request;

import com.davdavtyan.usercontact.dto.ContactType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

public record ContactRequest(@NotNull ContactType contactType, @NotNull String value) {

    @Email
    public String getEmail() {
        if (contactType == null || contactType != ContactType.EMAIL) {
            return null;
        }

        return value;
    }
}
