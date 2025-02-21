package com.dio.bank_pratice_project.service.impl;

import com.dio.bank_pratice_project.domain.model.User;
import com.dio.bank_pratice_project.domain.repository.UserRepository;
import com.dio.bank_pratice_project.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl  implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        Boolean existsUser = userRepository.existsByAccountNumber(user.getAccount().getNumber());

        if (existsUser) {
            throw new IllegalArgumentException("User already exists");
        }

        return userRepository.save(user);
    }
}
