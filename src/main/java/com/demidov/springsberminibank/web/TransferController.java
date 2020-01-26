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
import javax.validation.Valid;


    @Controller
    @RequestMapping("/transfer")
    public class TransferController {

        @Autowired
        private TransferAndRefillController transferAndRefillController;

        @ModelAttribute("operation")
        public MakeOperationDto makeOperationDto() {
            return new MakeOperationDto();
        }

        @GetMapping
        public String showTransferForm(Model model) {
            return "transfer";
        }

        @PostMapping
        public String makeTransferOperation(@ModelAttribute("operation") @Valid MakeOperationDto operationDto,
                                          BindingResult result) {

            transferAndRefillController.saveOperationTransfer(operationDto);
            return "redirect:/history?success";
        }

    }
