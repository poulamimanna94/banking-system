package com.hcl.bankingSystem.bankingsystem.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.bankingSystem.bankingsystem.controller.model.AccountRequest;
import com.hcl.bankingSystem.bankingsystem.controller.model.AccountResponse;
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

	@Override
	public AccountResponse getAccDetails(Long accountNumber) {
		AccountResponse accResponse = new AccountResponse();
		
		AccountDetails accDetails = accDao.findByAccountNumber(accountNumber);
		if(accDetails == null) {
			return accResponse;
		}

		String fName = accDetails.getFirstName();
		String mName = accDetails.getMiddleName();
		String lName = accDetails.getLastName();
		String fullName = fName + " " + mName + " " + lName;
		if (mName == null) {
			fullName = fName + " " + lName;

		}

		accResponse.setEmailId(accDetails.getEmailId());
		accResponse.setFullName(fullName);
		accResponse.setBalance(accDetails.getBalance());

		return accResponse;

	}

	@Override
	public boolean deleteAccDetails(Long accountNumber) {
		AccountDetails accDetails = accDao.findByAccountNumber(accountNumber);
		if(accDetails == null) {
			return false;
		}
		accDao.delete(accDetails);
		return true;
		
	}

}
