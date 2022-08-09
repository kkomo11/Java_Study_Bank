package com.iu.start.test;

import java.util.ArrayList;

import com.iu.start.bankbook.BankBookDAO;
import com.iu.start.bankbook.BankBookDTO;

public class BankBookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<BankBookDTO> arr = new ArrayList<BankBookDTO>();
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNum(1659507984047L);
		bankBookDTO.setBookName("아무거나2");
		bankBookDTO.setBookRate(2.68);
		try {
//			int result = bankBookDAO.setBankBook(bankBookDTO);
//			System.out.println(result);
			//----------------------------------------------------
			arr = bankBookDAO.getList();
			for(int i=0; i<arr.size(); i++) {
				System.out.println(arr.get(i).getBookNum() + "\t" + 
						arr.get(i).getBookName() + "\t" + arr.get(i).getBookRate() +
						"\t" + arr.get(i).getBooksale());
			}
			//------------------------------------------------------
			int row = bankBookDAO.setChangeSale(bankBookDTO);
			System.out.println(row);
			//------------------------------------------------------
			
//			BankBookDTO dto = new BankBookDTO();
//			dto = bankBookDAO.getDetail(bankBookDTO);
//			if(dto != null) {
//				System.out.println(dto.getBookNum() + "\t" + 
//						dto.getBookName() + "\t" + dto.getBookRate() +
//						"\t" + dto.getBooksale());
//			} else {
//				System.out.println("해당 번호는 없습니다.");
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}