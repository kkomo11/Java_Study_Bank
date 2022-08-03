package com.iu.start.test;

import java.sql.Connection;

import iu.com.start.util.DBConnector;

public class DBConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBConnector.getConnection();
			System.out.println(con != null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}