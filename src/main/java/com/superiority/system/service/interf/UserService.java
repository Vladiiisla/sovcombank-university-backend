package com.superiority.system.service.interf;

import com.superiority.system.domain.user.User;

public interface UserService extends CRUDService<User,Long> {
    User getByEmail(String email);
}
