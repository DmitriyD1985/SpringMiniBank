package com.demidov.springsberminibank.service;

import com.demidov.springsberminibank.web.dto.MakeOperationDto;
import com.demidov.springsberminibank.model.Operation;

import java.util.List;

public interface TransferAndRefillController {
    List <Operation> findOperationByUsername(String username);
    Operation saveOperationTransfer(MakeOperationDto makeOperationDto);
    Operation saveOperationRefill(MakeOperationDto makeOperationDto);
    List <Operation> findAllHistory();
}
