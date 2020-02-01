package com.demidov.springsberminibank.web;

import com.demidov.springsberminibank.model.User;
import com.demidov.springsberminibank.service.TransferAndRefillService;
import com.demidov.springsberminibank.service.UserService;
import com.demidov.springsberminibank.web.dto.MakeOperationDto;
import com.demidov.springsberminibank.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferAndRefillService transferAndRefillService;
    @Autowired
    private UserService userService;

    @ModelAttribute("operation")
    public MakeOperationDto makeOperationDto() {
        return new MakeOperationDto();
    }

        @GetMapping
        public String operationForm(Model model) {
            return "transfer";
        }

    @PostMapping
    public String makeTransfer(@ModelAttribute("operation") @Valid MakeOperationDto makeOperationDto,
                                      BindingResult result) {
            User checkUser = userService.findByUsername(makeOperationDto.getUsernameOne());

        if (checkUser == null) {
            result.rejectValue("usernameOne", "Получатель с таким именем не существует");
        }
        else if(Long.parseLong(makeOperationDto.getOperationSum()) > Long.parseLong(checkUser.getAccount()))
        {
            result.rejectValue("operationSum", "На счете недостаточно средств");
        }

            if (result.hasErrors()) {
                return "redirect:/error";
            }
            String operationName = "transfer";
            transferAndRefillService.save(makeOperationDto, operationName);
            return "redirect:/history";
        }
}