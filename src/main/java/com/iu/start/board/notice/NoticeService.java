package com.iu.start.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// 페이지당 15개씩
		// page		startRow		lastRow
		// 1		1				15
		// 2		16				30
		/*
		 * JSP에 페이지 번호 출력 1 - ?
		 * 1. 글의 총 개수 
		 * 2. 필요한 페이지 수 구하기
		 * 3. perBlock : 한 페이지에 출력할 번호의 수 = 5
		 * 4. totalBlock 수 구하기
		 * 5. p로 현재 block 번호 찾기
		 * 6. curBlock으로 시작번호와 끝번호 구하기
		 * */
		pager.getRowNum();
		Long totalCount = noticeDAO.findCount();
		pager.getNum(totalCount);
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}
}