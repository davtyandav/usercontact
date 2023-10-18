package com.davdavtyan.usercontact.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ElementCollection
//    @CollectionTable(name = "contact_emails", joinColumns = @JoinColumn(name = "contact_id"))
//    @Column(name = "email")
//    private List<String> emails;

//    @ElementCollection
//    @CollectionTable(name = "contact_phones", joinColumns = @JoinColumn(name = "contact_id"))
//    @Column(name = "phone")
//    private List<String> phones;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Email> emails = new ArrayList<>();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones = new ArrayList<>();

}
