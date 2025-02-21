package com.dio.bank_pratice_project.domain.repository;

import com.dio.bank_pratice_project.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByAccountNumber(String accountNumber);
}
