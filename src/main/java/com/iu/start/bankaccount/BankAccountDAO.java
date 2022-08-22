package com.iu.start.bankaccount;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountDAO implements AccountDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankaccount.BankAccountDAO.";
	
	@Override
	public int setAccount(BankAccountDTO bankAccountDTO) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.insert(NAMESPACE+"setAccount", bankAccountDTO);
	}
	
	@Override
	public List<Object[]> getList(BankAccountDTO bankAccountDTO) throws Exception {
		// TODO Auto-generated method stub

		return sqlSession.selectList(NAMESPACE+"getList", bankAccountDTO);
	}
}