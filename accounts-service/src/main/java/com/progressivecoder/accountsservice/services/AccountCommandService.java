package com.progressivecoder.accountsservice.services;

import com.progressivecoder.accountsservice.dto.AccountCreateDTO;
import com.progressivecoder.accountsservice.dto.MoneyCreditDTO;
import com.progressivecoder.accountsservice.dto.MoneyDebitDTO;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {

    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);
}
