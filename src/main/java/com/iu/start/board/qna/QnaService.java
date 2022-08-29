package com.iu.start.board.qna;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardFileDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private ServletContext servletContext;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = qnaDAO.findCount(pager);
		pager.getNum(totalCount);
		pager.getRow();
		
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		int result = qnaDAO.setAdd(boardDTO);
		String realPath = servletContext.getRealPath("/resources/upload/qna");
		for(MultipartFile photo : files) {
			File file = new File(realPath);
			if(!file.exists()) file.mkdirs();
			if(photo.isEmpty()) continue;
			String fileName = UUID.randomUUID().toString();
			fileName = fileName+"_"+photo.getOriginalFilename();
			file = new File(file, fileName);
			photo.transferTo(file);
			
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(photo.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			qnaDAO.setAddFile(boardFileDTO);
		}
		
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setDelete(boardDTO);
	}

	public int setReply(QnaDTO qnaDTO) throws Exception {
		QnaDTO parent = (QnaDTO) qnaDAO.getDetail(qnaDTO);
		
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		qnaDAO.setStep(parent);
		int result = qnaDAO.setReply(qnaDTO);
		return result;
	}
}
