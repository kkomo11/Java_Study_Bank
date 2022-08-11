package com.iu.start.bankmembers;

import java.util.ArrayList;

public interface MembersDAO {
	
	// BankMembers 테이블 회원가입 (insert)
	int setJoin(BankMembersDTO bankMembersDTO) throws Exception;
	
	// 검색어 입력 ID 찾기 abc순
	ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception;
	
	BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception;
}