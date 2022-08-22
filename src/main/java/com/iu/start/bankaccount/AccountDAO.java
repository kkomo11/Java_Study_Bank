package com.iu.start.bankaccount;

import java.util.List;

import com.iu.start.bankmembers.BankMembersDTO;

public interface AccountDAO {
	
	int setAccount(BankAccountDTO bankAccountDTO) throws Exception;
	
	List<BankAccountDTO> getList(BankMembersDTO bankMembersDTO) throws Exception;
}