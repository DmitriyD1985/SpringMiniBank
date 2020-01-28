package com.demidov.springsberminibank.service;

import com.demidov.springsberminibank.model.User;
import com.demidov.springsberminibank.web.dto.MakeOperationDto;
import com.demidov.springsberminibank.model.Operation;
import com.demidov.springsberminibank.repository.OperationRepository;
import com.demidov.springsberminibank.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransferAndRefillControllerImpl implements TransferAndRefillController{

    private OperationRepository operationRepository;
    private UserRepository userRepository;

    @Override
    public List<Operation> findOperationsByUsername(String username) {
        System.out.println(username);
        return operationRepository.findAllByUsername(username);
    }

    @Override
    public Operation saveOperationTransfer(MakeOperationDto makeOperationDto){
        Operation operation = new Operation();
        operation.setOperationName(makeOperationDto.getOperationName());
        operation.setOperationName("transfer");
        operation.setOperationSum(makeOperationDto.getOperationSum());
        operation.setUsernameOne(makeOperationDto.getUsernameOne());
        User user = userRepository.findByUsername(makeOperationDto.getUsername());
        User user1 = userRepository.findByUsername(makeOperationDto.getUsernameOne());
        long newAccount = user.getAccount()-operation.getOperationSum();
        if(newAccount>=0){
            user1.setAccount(user1.getAccount()+operation.getOperationSum());
            userRepository.save(user);
            userRepository.save(user1);
            return operationRepository.save(operation);
        }
        else return null;
    }

    @Override
    public Operation saveOperationRefill(MakeOperationDto makeOperationDto){
        Operation operation = new Operation();
        operation.setOperationName(makeOperationDto.getOperationName());
        operation.setOperationName("refill");
        operation.setOperationSum(makeOperationDto.getOperationSum());
        System.out.println(makeOperationDto.getOperationName());
        System.out.println(makeOperationDto.getUsername());
        User user = userRepository.findByUsername(makeOperationDto.getUsername());
        user.setAccount(user.getAccount()+operation.getOperationSum());
        userRepository.save(user);
        return operationRepository.save(operation);
    }

    public List<Operation> findAllHistory() {
        return operationRepository.findAll();
    }
}
