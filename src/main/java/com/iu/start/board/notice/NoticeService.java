package com.iu.start.board.notice;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		Long totalCount = noticeDAO.findCount(pager);
		pager.getNum(totalCount);
		pager.getRow();
		
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
	
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		
		String realpath = servletContext.getRealPath("/resources/upload/notice");
		
		for(int i=0; i<files.length; i++) {
			if(!files[i].isEmpty()) {
				File file = new File(realpath);
				if(!file.exists()) file.mkdirs();
				String fileName = UUID.randomUUID().toString();
				fileName = fileName+"_"+files[i].getOriginalFilename();
				file = new File(file, fileName);
				files[i].transferTo(file);
			}
		}
		
//		return noticeDAO.setAdd(boardDTO);
		return 0;
	}
}
