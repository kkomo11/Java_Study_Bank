package com.iu.start.board.qna;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.notice.NoticeDTO;
import com.iu.start.util.Pager;

public class QnaDAOTest extends MyAbstractTest {
	
	@Autowired
	private QnaDAO qnaDAO;

	@Test
	public void setAddTest() throws Exception {
		for(int i=0; i<100; i++) {
			QnaDTO qnaDTO = new QnaDTO();
			qnaDTO.setTitle("title"+i);
			qnaDTO.setContents("contents"+i);
			qnaDTO.setWriter("writer"+i);
			
			int num = qnaDAO.setAdd(qnaDTO);
			
			if(i%10==0) {
				Thread.sleep(500);
			}
		}
	}
	
//	@Test
	public void setDetailTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(1L);
		qnaDTO = (QnaDTO) qnaDAO.getDetail(qnaDTO);
		assertNotNull(qnaDTO);
	}
	
//	@Test
	public void getListTest() throws Exception {
		Pager pager = new Pager();
		List<BoardDTO> list = qnaDAO.getList(pager);
		assertNotEquals(0, list.size());
	}
	
//	@Test
	public void setUpdateTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("title1");
		qnaDTO.setContents("contents1");
		qnaDTO.setNum(1L);
		int result = qnaDAO.setUpdate(qnaDTO);
		assertEquals(1, result);
	}
	
//	@Test
	public void setDeleteTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(2L);
		int result = qnaDAO.setDelete(qnaDTO);
		assertEquals(1, result);
	}
}
