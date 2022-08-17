package com.iu.start.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.util.DBConnector;

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
	
		return result;
	}

	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM = ?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setLong(1, bankBookDTO.getBookNum());
		ResultSet rs = st.executeQuery();
		
		BankBookDTO dto = new BankBookDTO();
		if(rs.next()) {
			dto.setBookNum(rs.getLong("BOOKNUM"));
			dto.setBookName(rs.getString("BOOKNAME"));
			dto.setBookRate(rs.getDouble("BOOKRATE"));
			dto.setBookSale(rs.getInt("BOOKSALE"));
		}
		return dto;
	}

	@Override
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE BANKBOOK SET BOOKNAME=? , BOOKRATE=? WHERE BOOKNUM=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bankBookDTO.getBookName());
		st.setDouble(2, bankBookDTO.getBookRate());
		st.setLong(3, bankBookDTO.getBookNum());
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		return result;
	}

	@Override
	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBConnector.getConnection();
		String sql = "DELETE BANKBOOK WHERE BOOKNUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, bankBookDTO.getBookNum());
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		return result;
	}
}
