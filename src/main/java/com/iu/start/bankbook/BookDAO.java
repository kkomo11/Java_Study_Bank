package com.iu.start.bankbook;

import java.util.ArrayList;

public interface BookDAO {
	
	// bankbook table에 insert
	// 일련번호는 현재 시간을 밀리세컨드로 바꿔서 입력
	// 판매여부는 1로 시작
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception;
	
	// BankBook에 있는 모든 데이터 조회 최신순 정렬
	public ArrayList<BankBookDTO> getList() throws Exception;
	
	//판매여부 변경
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception;
	
	// BOOKNUM의 값으로 조회 
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception;
}