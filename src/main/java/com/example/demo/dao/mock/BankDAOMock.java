package com.example.demo.dao.mock;

import com.example.demo.bo.BankAccount;
import com.example.demo.dao.IBankDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Profile("mock")
@Component
public class BankDAOMock implements IBankDAO {

    List<BankAccount> bankAccountList;

    public BankDAOMock(){
        bankAccountList = new ArrayList<>();

        BankAccount b1 = new BankAccount();
        b1.id = 1L;
        b1.wallet = 2000;

        bankAccountList.add(b1);
    }

    @Override
    public BankAccount selectById(Long id) {
        return bankAccountList.stream()
                .filter(b -> b.id == id)
                .findFirst().orElse(null);
    }
}
