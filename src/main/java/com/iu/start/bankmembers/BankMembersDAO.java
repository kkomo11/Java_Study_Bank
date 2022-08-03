package com.iu.start.bankmembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import iu.com.start.util.DBConnector;

public class BankMembersDAO implements MembersDAO{

	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BANKMEMBERS VALUES (?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bankMembersDTO.getId());
		st.setString(2, bankMembersDTO.getPw());
		st.setString(3, bankMembersDTO.getName());
		st.setString(4, bankMembersDTO.getEmail());
		st.setString(5, bankMembersDTO.getPhone());
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		return result;
	}

	@Override
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<BankMembersDTO> arr = new ArrayList<BankMembersDTO>();
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANKMEMBERS WHERE ID LIKE ? ORDER BY ID ASC";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BankMembersDTO bankMembersDTO = new BankMembersDTO();
			
			bankMembersDTO.setId(rs.getString("ID"));
			bankMembersDTO.setPw(rs.getString("PW"));
			bankMembersDTO.setName(rs.getString("NAME"));
			bankMembersDTO.setEmail(rs.getString("EMAIL"));
			bankMembersDTO.setPhone(rs.getString("PHONE"));
			
			arr.add(bankMembersDTO);	
		}
		return arr;
	}
}