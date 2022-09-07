package com.iu.start.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.util.CommentPager;

@Repository
public class BankBookCommentDAO {
	
	private final String NAMESPACE = "com.iu.start.bankbook.BankBookCommentDAO.";
	
	@Autowired
	SqlSession sqlSession;

	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setCommentAdd", bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getCommentList", commentPager);
	}
	
	public Long findCount(CommentPager commentPager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"findCount", commentPager);
	}
	
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setCommentDelete", bankBookCommentDTO);
	}
	
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setCommentUpdate", bankBookCommentDTO);
	}
}