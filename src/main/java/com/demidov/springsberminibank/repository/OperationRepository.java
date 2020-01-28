package com.demidov.springsberminibank.repository;

import com.demidov.springsberminibank.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findAllByUsername(String username);

    User findByUsername(String username);
}