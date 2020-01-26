package com.demidov.springsberminibank.web;

import com.demidov.springsberminibank.service.TransferAndRefillController;
import com.demidov.springsberminibank.web.dto.MakeOperationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/refill")
public class RefillController {

    @Autowired
    private TransferAndRefillController transferAndRefillController;

    @ModelAttribute("operation")
    public MakeOperationDto makeOperationDto() {
        return new MakeOperationDto();
    }

    @GetMapping
    public String showTransferForm(Model model) {
        return "refill";
    }

    @PostMapping
    public String makeTransferOperation(@ModelAttribute("operation") MakeOperationDto operationDto,
                                        BindingResult result) {

        transferAndRefillController.saveOperationRefill(operationDto);
        return "redirect:/history?success";
    }

}
