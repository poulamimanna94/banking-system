package com.hcl.bankingSystem.bankingsystem.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bankingSystem.bankingsystem.controller.model.AccountRequest;
import com.hcl.bankingSystem.bankingsystem.dao.AccountDao;
import com.hcl.bankingSystem.bankingsystem.entity.AccountDetails;
import com.hcl.bankingSystem.bankingsystem.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accDao;

	@Override
	public Long createAccount(AccountRequest accReq) {

		AccountDetails accDetails = new AccountDetails();

		accDetails.setEmailId(accReq.getEmailId());
		accDetails.setFirstName(accReq.getFirstName());
		accDetails.setMiddleName(accReq.getMiddleName());
		accDetails.setLastName(accReq.getLastName());

		long accountNumber = System.currentTimeMillis();
		accDetails.setAccountNumber(accountNumber);

		try {

			AccountDetails saveResponse = accDao.save(accDetails);
			if (saveResponse == null) {
				return -1L;
				
			} else {
				return saveResponse.getAccountNumber();
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			return -1L;
		}

	}

}
