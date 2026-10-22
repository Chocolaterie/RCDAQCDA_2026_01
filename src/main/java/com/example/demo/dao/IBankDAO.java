package com.example.demo.dao;

import com.example.demo.bo.BankAccount;

public interface IBankDAO {

    public BankAccount selectById(Long id);
}
