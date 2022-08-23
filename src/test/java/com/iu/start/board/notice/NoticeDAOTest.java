package com.iu.start.board.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.board.impl.BoardDTO;

public class NoticeDAOTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void getListTest() throws Exception {
		List<BoardDTO> list = noticeDAO.getList();
		assertNotEquals(0, list.size());
	}
	
	@Test
	public void getDetailTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(2L);
		noticeDTO = (NoticeDTO) noticeDAO.getDetail(noticeDTO);
		assertNotNull(noticeDTO.getContents());
	}
	
	@Test
	public void setAddTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("title2");
		noticeDTO.setContents("contents2");
		noticeDTO.setWriter("writer2");
		
		int num = noticeDAO.setAdd(noticeDTO);
		assertEquals(1, num);
	}
	
	@Test
	public void setUpdateTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(2L);
		noticeDTO.setTitle("title3");
		noticeDTO.setContents("contents3");
		
		int num = noticeDAO.setUpdate(noticeDTO);
		assertEquals(1, num);
	}
	
	@Test
	public void setDeleteTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(66L);
		
		int num = noticeDAO.setDelete(noticeDTO);
		assertEquals(1, num);
	}
}