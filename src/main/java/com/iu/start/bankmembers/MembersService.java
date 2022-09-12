package com.iu.start.bankmembers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.util.FileManager;

@Service
public class MembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Autowired
	private FileManager fileManager;
		
	int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo, ServletContext servletContext) throws Exception {
		
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		String path = "/resources/upload/member";
		
		if(!photo.isEmpty()) {
			String fileName = fileManager.saveFile(path, photo, servletContext);
			
			BankMembersFileDTO bankMembersFileDTO = new BankMembersFileDTO();
			bankMembersFileDTO.setFileName(fileName);
			bankMembersFileDTO.setOriName(photo.getOriginalFilename());
			bankMembersFileDTO.setUserName(bankMembersDTO.getUserName());
			
			bankMembersDAO.setAddFile(bankMembersFileDTO);
		}
		return result;
	}
	
	// 검색어 입력 ID 찾기 abc순
	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
		return bankMembersDAO.getSearchByID(search);
	}
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	public BankMembersDTO myPage(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.myPage(bankMembersDTO);
	}
	
	public BankMembersDTO duplicateCheck(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.duplicateCheck(bankMembersDTO);
	}
}