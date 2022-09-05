package com.iu.start.bankbook;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookCommentDAO {
	
	private final String NAMESPACE = "com.iu.start.bankbook.BankBookCommentDAO.";
	
	@Autowired
	SqlSession sqlSession;

	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setCommentAdd", bankBookCommentDTO);
	}
}