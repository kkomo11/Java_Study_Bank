package com.iu.start.bankbook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.util.CommentPager;

public class BankBookCommentTest extends MyAbstractTest {
	
	@Autowired
	BankBookCommentDAO bankBookCommentDAO;
	
//	@Test
	public void setCommentAddTest() throws Exception {
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setBookNum(1662359690759L);
		bankBookCommentDTO.setContents("adfadfad");
		bankBookCommentDTO.setWriter("id5");
		
		int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
		assertEquals(1, result);
	}
	
//	@Test
	public void getCommentListTest() throws Exception {

		CommentPager commentPager = new CommentPager();
		commentPager.setBookNum(1662359690759L);
		commentPager.getRow();
		List<BankBookCommentDTO> list = bankBookCommentDAO.getCommentList(commentPager);
		assertNotEquals(0, list.size());
	}
	
//	@Test
	public void findCountTest() throws Exception {
		CommentPager commentPager = new CommentPager();
		commentPager.setBookNum(1662359690759L);
		long totalCount = bankBookCommentDAO.findCount(commentPager);
		assertNotEquals(0, totalCount);
	}
	
//	@Test
	public void setCommentDeleteTest() throws Exception {
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setNum(170L);
		int result = bankBookCommentDAO.setCommentDelete(bankBookCommentDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void setCommentUpdate() throws Exception {
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setNum(164L);
		bankBookCommentDTO.setContents("change");
		int result = bankBookCommentDAO.setCommentUpdate(bankBookCommentDTO);
		assertEquals(1, result);
	}
}
