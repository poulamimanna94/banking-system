package com.hcl.bankingSystem.bankingsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankingSystem.bankingsystem.controller.model.AccountRequest;
import com.hcl.bankingSystem.bankingsystem.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accService;
	
	@PostMapping("/account/createAccount")
	public Long createAccount(@RequestBody AccountRequest acRe) {
		Long accNumber = accService.createAccount(acRe);
		return accNumber;
		
	}

}
