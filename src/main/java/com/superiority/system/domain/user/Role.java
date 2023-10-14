package com.superiority.system.domain.user;

public enum Role {
    // Роль пользователя. Предоставляет базовые права.
    ROLE_USER,
    // Роль администратора. Предоставляет полные права на управление системой.
    ROLE_ADMIN,

    ROLE_STUDENT,
    ROLE_TEACHER,
    ROLE_EDITOR,
    ROLE_MENTOR,
    ROLE_SELECTION_COMMITTEE
}
