package com.iu.start.bankaccount;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.bankmembers.BankMembersDTO;

@Repository
public class BankAccountDAO implements AccountDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankaccount.BankAccountDAO.";
	
	@Override
	public int setAccount(BankAccountDTO bankAccountDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setAccount", bankAccountDTO);
	}
	
	@Override
	public List<BankAccountDTO> getList(BankMembersDTO bankMembersDTO) throws Exception {

		return sqlSession.selectList(NAMESPACE+"getList", bankMembersDTO);
	}
}