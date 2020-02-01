package com.demidov.springsberminibank.service;

import com.demidov.springsberminibank.model.User;
import com.demidov.springsberminibank.web.dto.MakeOperationDto;
import com.demidov.springsberminibank.model.Operation;
import com.demidov.springsberminibank.repository.OperationRepository;
import com.demidov.springsberminibank.repository.UserRepository;
import com.demidov.springsberminibank.web.dto.MakeRefill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransferAndRefillServiceImpl implements TransferAndRefillService {
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Operation> findByUsername(String username) {
        return operationRepository.findAllByUsername(username);
    }

    @Override
    public Operation save(MakeOperationDto makeOperationDto, String operationName) {
        Operation operation = new Operation();
        operation.setOperationName(operationName);
        operation.setOperationSum(makeOperationDto.getOperationSum());
        operation.setUsernameOne(makeOperationDto.getUsernameOne());
        operation.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(name);
        User user1 = userRepository.findByUsername(makeOperationDto.getUsernameOne());
        long newAccount = Long.parseLong(user.getAccount()) - Long.parseLong(operation.getOperationSum());
        if (newAccount >= 0) {
            user1.setAccount(String.valueOf(Long.parseLong(user1.getAccount()) + Long.parseLong(operation.getOperationSum())));
            user.setAccount(String.valueOf(newAccount));
            userRepository.save(user);
            userRepository.save(user1);
            return operationRepository.save(operation);
        } else {
            return null;}
    }

    @Override
    public Operation save(MakeRefill makeRefill, String operationName) {
        Operation operation = new Operation();
        operation.setOperationName(operationName);
        operation.setOperationSum(makeRefill.getOperationSum());
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        operation.setUsernameOne(name);
        operation.setUsername(name);
        User user = userRepository.findByUsername(name);
        long newAccount = Long.parseLong(user.getAccount()) + Long.parseLong(operation.getOperationSum());
        user.setAccount(String.valueOf(newAccount));
        userRepository.save(user);
        return operationRepository.save(operation);
    }
}
