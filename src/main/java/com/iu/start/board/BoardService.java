package com.iu.start.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private BankBoardDAO bankBoardDAO;
	
	ArrayList<BankBoardDTO> getList() throws Exception {
		return bankBoardDAO.getList();
	}
	
	BankBoardDTO getDetail(BankBoardDTO bankBoardDTO) throws Exception {
		return bankBoardDAO.getDetail(bankBoardDTO);
	}
	
	int setWriting(BankBoardDTO bankBoardDTO) throws Exception {
		return bankBoardDAO.setWriting(bankBoardDTO);
	}
	
	int updateWriting(BankBoardDTO bankBoardDTO) throws Exception {
		return bankBoardDAO.updateWriting(bankBoardDTO);
	}
	
	int deleteWriting(BankBoardDTO bankBoardDTO) throws Exception {
		return bankBoardDAO.deleteWriting(bankBoardDTO);
	}
	
	public int addHit(BankBoardDTO bankBoardDTO) throws Exception {
		return bankBoardDAO.addHit(bankBoardDTO);
	}
}