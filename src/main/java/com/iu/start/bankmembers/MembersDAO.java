package com.iu.start.bankmembers;

import java.util.ArrayList;

public interface MembersDAO {
	
	// BankMembers 테이블 회원가입 (insert)
	public abstract int setJoin(BankMembersDTO bankMembersDTO) throws Exception;
	
	// 검색어 입력 ID 찾기 abc순
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception;
}