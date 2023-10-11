package com.superiority.system.service.implementation;

import com.superiority.system.domain.user.User;
import com.superiority.system.service.interf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation extends AbstractCRUDService<User,Long> implements UserService {
    @Override
    JpaRepository<User, Long> getRepository() {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }
}
