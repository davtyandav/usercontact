package com.davdavtyan.usercontact.service;

import java.util.List;

import com.davdavtyan.usercontact.dto.ContactType;
import com.davdavtyan.usercontact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
   List<Contact> findByUserId(Long userId);
    List<Contact> findContactsByUserIdAndContactType(Long userId, ContactType type);
}