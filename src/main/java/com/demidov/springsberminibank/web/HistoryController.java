package com.demidov.springsberminibank.web;

import com.demidov.springsberminibank.service.TransferAndRefillService;
import com.demidov.springsberminibank.model.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HistoryController {

    @Autowired
    TransferAndRefillService transferAndRefillController;

    @GetMapping("/history")
    public String showAllОperationHistory(Model model)
    {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Operation> listO = transferAndRefillController.findByUsername(name);
        model.addAttribute("operations", listO);
        return "history";
    }
}