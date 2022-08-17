package com.iu.start.bankaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	BankAccountDAO bankAccountDAO;
	
	int setAccount(BankAccountDTO bankAccountDTO) throws Exception {
		return bankAccountDAO.setAccount(bankAccountDTO);
	}
}