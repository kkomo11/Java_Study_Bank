package com.iu.start.board.impl;

import java.util.List;

public interface BoardService {
	
	// 글 목록
	List<BoardDTO> getList(Long p) throws Exception;

	// 글 상세보기
	BoardDTO getDetail(BoardDTO boardDTO) throws Exception; 
		
	// 글 쓰기
	int setAdd(BoardDTO boardDTO) throws Exception;
		
	// 글 수정
	int setUpdate(BoardDTO boardDTO) throws Exception;
		
	// 글 삭제
	int setDelete(BoardDTO boardDTO) throws Exception;
}