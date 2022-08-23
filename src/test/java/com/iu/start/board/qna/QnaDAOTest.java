package com.iu.start.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.board.impl.BoardDTO;

public class QnaDAOTest extends MyAbstractTest {
	
	@Autowired
	private QnaDAO qnaDAO;

	@Test
	public void setAddTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("title1");
		qnaDTO.setContents("contents1");
		qnaDTO.setWriter("writer1");
		int result = qnaDAO.setAdd(qnaDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void setDetailTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(1L);
		qnaDTO = (QnaDTO) qnaDAO.getDetail(qnaDTO);
		assertNotNull(qnaDTO);
	}
	
	@Test
	public void getListTest() throws Exception {
		List<BoardDTO> list = qnaDAO.getList();
		assertNotEquals(0, list.size());
	}
	
	@Test
	public void setUpdateTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("title1");
		qnaDTO.setContents("contents1");
		qnaDTO.setNum(1L);
		int result = qnaDAO.setUpdate(qnaDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void setDeleteTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(2L);
		int result = qnaDAO.setDelete(qnaDTO);
		assertEquals(1, result);
	}
}