package com.superiority.system.domain.user;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@MappedSuperclass
public class User implements Serializable {
    // Уникальный идентификатор пользователя.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Имя пользователя.
    @Column(name="firstname")
    private String firstname;
    // Фамилия пользователя.
    @Column(name="lastname")
    private String lastname;
    // Адрес электронной почты пользователя.
    @Column(name = "email")
    private String email;
    // Пароль пользователя (зашифрованный).
    @Column(name = "password")
    private String password;
    // Поле для подтверждения пароля, не сохраняется в базе данных.
    @Transient
    private String passwordConfirmation;
    // Роли пользователя, например, администратор, пользователь и др.
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "users_roles")
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles;
    // Номер телефона пользователя.
    @Column(name = "phone_number")
    private String phoneNUmber;
    // Адрес пользователя.
    @Column(name = "address")
    private String address;
    // Дата рождения пользователя.
    @Column(name = "birth_date")
    private Date birthDate;
    // Пол пользователя.
    @Column(name = "gender")
    private String gender;
    // Национальность пользователя.
    @Column(name = "nationality")
    private String nationality;
    // Предыдущий опыт работы пользователя.
    @Column(name = "previous_experience")
    private String previousExperience;
    // Контакт в случае экстренной ситуации.
    @Column(name = "emergency_contact")
    private String emergencyContact;
    // Телефон экстренного контакта.
    @Column(name = "emergency_contact_phone")
    private String emergencyContactPhone;
    // URL фотографии пользователя.
    @Column(name = "photo_url")
    private String photoUrl;
    // Информация о образовании пользователя.
    @Column(name = "education")
    private String education;
}
