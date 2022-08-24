package com.iu.start.board.impl;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
	
	// 글 목록
	List<BoardDTO> getList(Map<String, Long> map) throws Exception;

	// 글 상세보기
	BoardDTO getDetail(BoardDTO boardDTO) throws Exception; 
	
	// 글 쓰기
	int setAdd(BoardDTO boardDTO) throws Exception;
	
	// 글 수정
	int setUpdate(BoardDTO boardDTO) throws Exception;
	
	// 글 삭제
	int setDelete(BoardDTO boardDTO) throws Exception;
	
	// 글 개수 조회
	Long findCount() throws Exception;
}