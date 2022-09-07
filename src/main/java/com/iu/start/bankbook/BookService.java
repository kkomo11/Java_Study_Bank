package com.iu.start.bankbook;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.util.CommentPager;

@Service
public class BookService {

	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		Calendar ca = Calendar.getInstance();	
		bankBookDTO.setBookNum(ca.getTimeInMillis());
				
		return bankBookDAO.setBankBook(bankBookDTO);
	}
	
	// BankBook에 있는 모든 데이터 조회 최신순 정렬
	public List<BankBookDTO> getList() throws Exception {
		return bankBookDAO.getList();
	}
	
	//판매여부 변경
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setChangeSale(bankBookDTO);
	}
	
	// BOOKNUM의 값으로 조회 
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setDelete(bankBookDTO);
	}
	
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager) throws Exception {
		
		Long totalCount = bankBookCommentDAO.findCount(commentPager);
		commentPager.getRow();
		commentPager.setTotalPage(totalCount);
		
		return bankBookCommentDAO.getCommentList(commentPager);
	}
	
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return bankBookCommentDAO.setCommentDelete(bankBookCommentDTO);
	}
	
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return bankBookCommentDAO.setCommentUpdate(bankBookCommentDTO);
	}
}