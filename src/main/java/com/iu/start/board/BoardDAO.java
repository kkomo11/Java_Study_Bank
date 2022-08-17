package com.iu.start.board;

import java.util.ArrayList;

public interface BoardDAO {
	
	ArrayList<BankBoardDTO> getList() throws Exception;
	
	BankBoardDTO getDetail(BankBoardDTO bankBoardDTO) throws Exception;
	
	int setWriting(BankBoardDTO bankBoardDTO) throws Exception;
	
	int updateWriting(BankBoardDTO bankBoardDTO) throws Exception;
	
	int deleteWriting(BankBoardDTO bankBoardDTO) throws Exception;
	
	public int addHit(BankBoardDTO bankBoardDTO) throws Exception;
}