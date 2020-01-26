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
        System.out.println("Ищем операции по" + name);
        System.out.println("История операций проверка 1");
        List<Operation> allHistory = transferAndRefillController.findAllHistory();
//        List<Operation> allHistory = new ArrayList<>();
        allHistory.add(new Operation("1",1,"1","1",1));
        System.out.println("История операций оверка 2");
        System.out.println("История операций "+ allHistory.toString());
        model.addAttribute("allhistory", allHistory);
        return "history";
    }
}