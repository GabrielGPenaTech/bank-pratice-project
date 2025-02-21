package com.dio.bank_pratice_project.service;

import com.dio.bank_pratice_project.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User user);
}
