package com.iu.start.bankmembers;

import java.io.File;
import java.util.Calendar;
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
	
	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo) throws Exception {
	
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		String realPath = servletContext.getRealPath("resources/upload/member");
		File file = new File(realPath);
		
		if(!photo.isEmpty()) {		
			if(!file.exists()) { // 폴더가 없을 경우 생성
				file.mkdirs();
			}
			String fileName = UUID.randomUUID().toString();
			fileName = fileName+"_"+photo.getOriginalFilename();
			
			file = new File(file, fileName);
			
			// MultipartFile
			photo.transferTo(file);
			
			// db저장
			BankMembersFileDTO bankMembersFileDTO = new BankMembersFileDTO();
			bankMembersFileDTO.setFileName(fileName);
			bankMembersFileDTO.setOriName(photo.getOriginalFilename());
			bankMembersFileDTO.setId(bankMembersDTO.getId());
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
}