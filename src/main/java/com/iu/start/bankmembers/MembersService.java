package com.iu.start.bankmembers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
//	@Autowired
//	private BankAccountDAO bankAccountDAO;
	
	int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.setJoin(bankMembersDTO);
	}
	
	// 검색어 입력 ID 찾기 abc순
	List<BankMembersDTO> getSearchByID(String search) throws Exception {
		return bankMembersDAO.getSearchByID(search);
	}
	
	BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
//	Map<String, Object> myPage(BankMembersDTO bankMembersDTO) throws Exception {
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<BankAccountDTO> arr = bankAccountDAO.getList(bankMembersDTO);
//		bankMembersDTO = bankMembersDAO.myPage(bankMembersDTO);
//		map.put("list", arr);
//		map.put("dto", bankMembersDTO);
//		return map;
//	}
	
	public BankMembersDTO myPage(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.myPage(bankMembersDTO);
	}
}