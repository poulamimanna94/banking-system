package com.hcl.bankingSystem.bankingsystem.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.hcl.bankingSystem.bankingsystem.controller.model.AccountRequest;
import com.hcl.bankingSystem.bankingsystem.controller.model.AccountResponse;

public interface AccountService {
	public Long createAccount(AccountRequest accReq);

	public AccountResponse getAccDetails(Long accountNumber);

	public boolean deleteAccDetails(Long accountNumber);

}
