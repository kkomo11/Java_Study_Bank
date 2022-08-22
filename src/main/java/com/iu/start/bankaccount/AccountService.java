package com.iu.start.bankaccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.bankmembers.BankMembersDTO;

@Service
public class AccountService {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	public int setAccount(BankAccountDTO bankAccountDTO) throws Exception {
		return bankAccountDAO.setAccount(bankAccountDTO);
	}
	
	public List<BankAccountDTO> getList(BankMembersDTO bankMembersDTO) throws Exception {
		return bankAccountDAO.getList(bankMembersDTO);
	}
}