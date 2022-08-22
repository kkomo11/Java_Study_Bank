package com.iu.start.bankaccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	int setAccount(BankAccountDTO bankAccountDTO) throws Exception {
		return bankAccountDAO.setAccount(bankAccountDTO);
	}
	
	List<Object[]> getList(BankAccountDTO bankAccountDTO) throws Exception {
		return bankAccountDAO.getList(bankAccountDTO);
	}
}