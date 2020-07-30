package com.hcl.bankingSystem.bankingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankingSystem.bankingsystem.controller.model.AccountRequest;
import com.hcl.bankingSystem.bankingsystem.controller.model.AccountResponse;
import com.hcl.bankingSystem.bankingsystem.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accService;

	@PostMapping("/account/createAccount")
	public Long createAccount(@RequestBody AccountRequest accReq) {

		Long accNumber = accService.createAccount(accReq);
		return accNumber;

	}

	@GetMapping("/account/getAccDetails/{accountNumber}")
	public AccountResponse getAccDetails(@PathVariable Long accountNumber) {

		AccountResponse response = accService.getAccDetails(accountNumber);

		return response;

	}

	@DeleteMapping("/account/deleteAccDetails/{accountNumber}")
	public boolean deleteAccDetails(@PathVariable Long accountNumber) {

		boolean accResponse = accService.deleteAccDetails(accountNumber);

		return accResponse;

	}

}
