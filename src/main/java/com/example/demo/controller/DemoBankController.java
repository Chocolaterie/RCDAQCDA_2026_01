package com.example.demo.controller;

import com.example.demo.bo.Person;
import com.example.demo.bo.ServiceResponse;
import com.example.demo.bo.WithdrawRequestDTO;
import com.example.demo.bo.BankAccount;

import com.example.demo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoBankController {

    List<Person> persons;

    BankAccount bankAccount;

    @Autowired
    BankService bankService;

    public DemoBankController(){
        // Creer un faux compte banquaire qui contient 10 000€
        bankAccount = new BankAccount();
        bankAccount.wallet = 10000;
    }

    @PostMapping("/withdraw")
    public ServiceResponse withdraw(@RequestBody WithdrawRequestDTO withdrawRequestDTO){
        return bankService.withdraw(withdrawRequestDTO);
    }

}
