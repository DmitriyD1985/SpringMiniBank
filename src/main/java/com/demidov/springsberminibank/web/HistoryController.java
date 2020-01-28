package com.demidov.springsberminibank.web;

import com.demidov.springsberminibank.service.TransferAndRefillController;
import com.demidov.springsberminibank.model.Operation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HistoryController {

    TransferAndRefillController transferAndRefillController;

    @GetMapping("/history")
    public String showAllОperationHistory(Model model)
    {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(name);
        List<Operation> listO = transferAndRefillController.findOperationsByUsername(name);
        System.out.println(listO.toString());
        model.addAllAttributes(listO);
        return "history";
    }


}