package com.iu.start.bankbook;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;

public class BankBookCommentTest extends MyAbstractTest {
	
	@Autowired
	BankBookCommentDAO bankBookCommentDAO;
	
	@Test
	public void setCommentAdd() throws Exception {
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setBookNum(1662359690759L);
		bankBookCommentDTO.setContents("adfadfad");
		bankBookCommentDTO.setWriter("id5");
		
		int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
		assertEquals(1, result);
	}
}
