package com.example.demo.service.account;

import com.example.demo.model.account.Account;

public interface IAccountService {
    Account findByUsername(String username);
}
