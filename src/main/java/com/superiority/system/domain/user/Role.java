package com.superiority.system.domain.user;

public enum Role {
    // Роль пользователя. Предоставляет базовые права.
    ROLE_USER,
    // Роль администратора. Предоставляет полные права на управление системой.
    ROLE_ADMIN,

    ROLE_AUTHOR,
    ROLE_MODERATOR,
    ROLE_EDITOR
}
