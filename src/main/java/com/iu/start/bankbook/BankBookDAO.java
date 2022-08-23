package com.iu.start.bankbook;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookDAO implements BookDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.start.bankbook.BankBookDAO.";
	
	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.insert(NAMESPACE+"setBankBook", bankBookDTO);
	}

	@Override
	public List<BankBookDTO> getList() throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList(NAMESPACE+"getList");
	}

	
	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
	
		return sqlSession.update(NAMESPACE+"setChangeSale");
	}

	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(NAMESPACE+"getDetail", bankBookDTO);
	}

	@Override
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.update(NAMESPACE+"setUpdate", bankBookDTO);
	}

	@Override
	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub

		return sqlSession.delete(NAMESPACE+"setDelete", bankBookDTO);
	}
}
