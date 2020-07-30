package com.hcl.bankingSystem.bankingsystem.service;

import com.hcl.bankingSystem.bankingsystem.controller.model.AccountRequest;

public interface AccountService {
	public Long createAccount(AccountRequest accReq);

}
