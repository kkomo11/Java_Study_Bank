package com.iu.start.bankmembers;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Autowired
	private ServletContext servletContext;
		
	int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo) throws Exception {
		
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		String realPath = servletContext.getRealPath("/resources/upload/member");
		System.out.println(realPath);
		
		File file = new File(realPath);
		if(!file.exists()) file.mkdirs();
		if(!photo.isEmpty()) {
			String fileName = UUID.randomUUID().toString();
			fileName = fileName+"_"+photo.getOriginalFilename();
			file = new File(file, fileName);
			photo.transferTo(file);
			
			BankMembersFileDTO bankMembersFileDTO = new BankMembersFileDTO();
			bankMembersFileDTO.setFileName(fileName);
			bankMembersFileDTO.setOriName(photo.getOriginalFilename());
			bankMembersFileDTO.setId(bankMembersDTO.getId());
			
			bankMembersDAO.setAddFile(bankMembersFileDTO);
		}
		return result;
	}
	
	// 검색어 입력 ID 찾기 abc순
	List<BankMembersDTO> getSearchByID(String search) throws Exception {
		return bankMembersDAO.getSearchByID(search);
	}
	
	BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	public BankMembersDTO myPage(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.myPage(bankMembersDTO);
	}
}