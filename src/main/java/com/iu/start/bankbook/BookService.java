package com.iu.start.bankbook;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BankBookDAO bankBookDAO;
	
	int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		Calendar ca = Calendar.getInstance();	
		bankBookDTO.setBookNum(ca.getTimeInMillis());
				
		return bankBookDAO.setBankBook(bankBookDTO);
	}
	
	// BankBook에 있는 모든 데이터 조회 최신순 정렬
	List<BankBookDTO> getList() throws Exception {
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