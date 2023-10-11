package com.superiority.system.service.implementation;

import com.superiority.system.domain.exception.ResourceNotFoundException;
import com.superiority.system.domain.user.Role;
import com.superiority.system.domain.user.User;
import com.superiority.system.repository.UserRepository;
import com.superiority.system.service.interf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation extends AbstractCRUDService<User,Long> implements UserService {
   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;
    @Override
    JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    @Transactional
    public void create(User entity) {
        if(userRepository.findByEmail(entity.getEmail()).isPresent()){
            throw new IllegalStateException("User already exists.");
        }
        if(!entity.getPassword().equals(entity.getPasswordConfirmation())){
            throw new IllegalStateException("Password and password confirmation do not match");
        }
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        Set<Role> roles = Set.of(Role.ROLE_USER);
        entity.setRoles(roles);
        userRepository.save(entity);
    }

    @Override
    @Transactional
    public User update(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        userRepository.save(entity);
        return entity;
    }

    @Override
    @Transactional(readOnly = true)
    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("User not found"));
    }
}
