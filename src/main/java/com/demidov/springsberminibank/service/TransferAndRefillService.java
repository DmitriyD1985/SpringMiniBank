package com.demidov.springsberminibank.service;

import com.demidov.springsberminibank.model.User;
import com.demidov.springsberminibank.web.dto.MakeOperationDto;
import com.demidov.springsberminibank.model.Operation;
import com.demidov.springsberminibank.web.dto.MakeRefill;
import com.demidov.springsberminibank.web.dto.UserRegistrationDto;

import java.util.List;

public interface TransferAndRefillService {
    List <Operation> findByUsername(String username);
    Operation save(MakeOperationDto makeOperationDto, String operationName);
    Operation save(MakeRefill makeRefill, String operationName);
}