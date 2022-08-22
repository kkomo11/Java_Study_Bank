package com.iu.start.bankaccount;

import java.util.List;

public interface AccountDAO {
	
	int setAccount(BankAccountDTO bankAccountDTO) throws Exception;
	
	List<Object[]> getList(BankAccountDTO bankAccountDTO) throws Exception;
}