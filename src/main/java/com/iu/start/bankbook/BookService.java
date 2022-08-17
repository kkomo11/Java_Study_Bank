package com.iu.start.bankbook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	BankBookDAO bankBookDAO;
	
	int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setBankBook(bankBookDTO);
	}
	
	// BankBook에 있는 모든 데이터 조회 최신순 정렬
	ArrayList<BankBookDTO> getList() throws Exception {
		return bankBookDAO.getList();
	}
	
	//판매여부 변경
	int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setChangeSale(bankBookDTO);
	}
	
	// BOOKNUM의 값으로 조회 
	BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	int setDelete(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setDelete(bankBookDTO);
	}
}