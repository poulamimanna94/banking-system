package com.hcl.bankingSystem.bankingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bankingSystem.bankingsystem.entity.AccountDetails;

public interface AccountDao extends JpaRepository<AccountDetails, Long> {
	AccountDetails findByAccountNumber(long accountNumber);


}
