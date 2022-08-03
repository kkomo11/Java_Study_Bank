package com.iu.start.test;

import java.util.ArrayList;

import com.iu.start.bankmembers.BankMembersDAO;
import com.iu.start.bankmembers.BankMembersDTO;

public class BankMembersTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<BankMembersDTO> arr = new ArrayList<BankMembersDTO>();
		String text = "실패";
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setId("id4");
		bankMembersDTO.setPw("pw4");
		bankMembersDTO.setName("name4");
		bankMembersDTO.setEmail("email4");
		bankMembersDTO.setPhone("010-4444");
		
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		try {
			int result = bankMembersDAO.setJoin(bankMembersDTO);
			if(result == 1) text = "성공";
			System.out.println(text);
			
			arr = bankMembersDAO.getSearchByID("2");
			for(int i=0; i<arr.size(); i++) {
				System.out.println(arr.get(i).getId());
				System.out.println(arr.get(i).getPw());
				System.out.println(arr.get(i).getName());
				System.out.println(arr.get(i).getEmail());
				System.out.println(arr.get(i).getPhone());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}