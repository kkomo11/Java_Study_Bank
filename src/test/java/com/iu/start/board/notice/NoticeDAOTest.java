package com.iu.start.board.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.util.Pager;

public class NoticeDAOTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
	public void getListTest() throws Exception {
		Pager pager = new Pager();
		List<BoardDTO> list = noticeDAO.getList(pager);
		assertNotEquals(0, list.size());
	}
	
///	@Test
	public void getDetailTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(2L);
		noticeDTO = (NoticeDTO) noticeDAO.getDetail(noticeDTO);
		assertNotNull(noticeDTO.getContents());
	}
	
//	@Test
	public void setAddTest() throws Exception {
		for(int i=0; i<100; i++) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setTitle("title"+i);
			noticeDTO.setContents("contents"+i);
			noticeDTO.setWriter("writer"+i);
			
			int num = noticeDAO.setAdd(noticeDTO);
			
			if(i%10==0) {
				Thread.sleep(500);
			}
		}
//		assertEquals(1, num);
	}
	
//	@Test
	public void setUpdateTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(2L);
		noticeDTO.setTitle("title3");
		noticeDTO.setContents("contents3");
		
		int num = noticeDAO.setUpdate(noticeDTO);
		assertEquals(1, num);
	}
	
//	@Test
	public void setDeleteTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(66L);
		
		int num = noticeDAO.setDelete(noticeDTO);
		assertEquals(1, num);
	}
	
	@Test
	public void findCountTest() throws Exception {
		Pager pager = new Pager();
		Long result = noticeDAO.findCount(pager);
		assertEquals(0, result.compareTo(136L));
	}
}