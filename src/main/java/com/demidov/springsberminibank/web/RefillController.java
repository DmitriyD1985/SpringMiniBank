package com.demidov.springsberminibank.web;

import com.demidov.springsberminibank.service.TransferAndRefillService;
import com.demidov.springsberminibank.web.dto.MakeOperationDto;
import com.demidov.springsberminibank.web.dto.MakeRefill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/refill")
public class RefillController {

    @Autowired
    private TransferAndRefillService transferAndRefillService;

    @ModelAttribute("operation")
    public MakeRefill makeRefill() {
        return new MakeRefill();
    }

    @GetMapping
    public String operationForm(Model model) {
        return "refill";
    }

    @PostMapping
    public String makeRefill(@ModelAttribute("operation") @Valid MakeRefill makeRefill,
                                      BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        String operationName = "refill";
        transferAndRefillService.save(makeRefill, operationName);
        return "redirect:/history";
    }
}