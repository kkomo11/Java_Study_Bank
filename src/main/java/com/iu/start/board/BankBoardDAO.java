package com.iu.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BankBoardDAO implements BoardDAO{

	@Override
	public ArrayList<BankBoardDTO> getList() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<BankBoardDTO> arr = new ArrayList<BankBoardDTO>();
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BOARD";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BankBoardDTO bankBoardDTO = new BankBoardDTO();
			bankBoardDTO.setNo(rs.getInt("NO"));
			bankBoardDTO.setTitle(rs.getString("TITLE"));
			bankBoardDTO.setContents(rs.getString("CONTENTS"));
			bankBoardDTO.setId(rs.getString("ID"));
			bankBoardDTO.setWriteDate(rs.getDate("WRITEDATE"));
			bankBoardDTO.setHit(rs.getInt("HIT"));
			
			arr.add(bankBoardDTO);
		}
		
		
		DBConnector.disConnection(rs, st, con);
		
		return arr;
	}

	@Override
	public BankBoardDTO getDetail(BankBoardDTO bankBoardDTO) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BOARD WHERE NO = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, bankBoardDTO.getNo());
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			bankBoardDTO.setTitle(rs.getString("TITLE"));
			bankBoardDTO.setContents(rs.getString("CONTENTS"));
			bankBoardDTO.setId(rs.getString("ID"));
			bankBoardDTO.setWriteDate(rs.getDate("WRITEDATE"));
			bankBoardDTO.setHit(rs.getInt("HIT"));
		}
		
		DBConnector.disConnection(rs, st, con);
		
		return bankBoardDTO;
	}

	@Override
	public int setWriting(BankBoardDTO bankBoardDTO) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BOARD (NO, TITLE, CONTENTS, ID, WRITEDATE) VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bankBoardDTO.getTitle());
		st.setString(2, bankBoardDTO.getContents());
		st.setString(3, bankBoardDTO.getId());
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		return result;
	}

	@Override
	public int updateWriting(BankBoardDTO bankBoardDTO) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE BOARD SET TITLE = ?, CONTENTS = ? WHERE NO = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bankBoardDTO.getTitle());
		st.setString(2, bankBoardDTO.getContents());
		st.setInt(3, bankBoardDTO.getNo());
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		return result;
	}

	@Override
	public int deleteWriting(BankBoardDTO bankBoardDTO) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBConnector.getConnection();
		String sql = "DELETE BOARD WHERE NO = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, bankBoardDTO.getNo());
		int result = st.executeUpdate();
		
		return result;
	}
	
	public int addHit(BankBoardDTO bankBoardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "SELECT HIT FROM BOARD WHERE NO = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, bankBoardDTO.getNo());
		ResultSet rs = st.executeQuery();
		if(rs.next()) bankBoardDTO.setHit(rs.getInt("HIT"));
		
		sql = "UPDATE BOARD SET HIT = ? WHERE NO = ?";
		st = con.prepareStatement(sql);
		st.setInt(1, bankBoardDTO.getHit()+1);
		st.setInt(2, bankBoardDTO.getNo());
		int result = st.executeUpdate();
		
		DBConnector.disConnection(rs, st, con);
		return result;
	}
}