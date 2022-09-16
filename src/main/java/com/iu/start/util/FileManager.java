package com.iu.start.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.file.FileDTO;

@Component
public class FileManager {

	public String saveFile(String path, MultipartFile multipartFile, ServletContext servletContext) throws Exception {
		String realPath = servletContext.getRealPath(path);
		File file = new File(realPath);
		String fileName=null;
		if(!file.exists()) file.mkdirs();
		fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		file = new File(file, fileName);
		multipartFile.transferTo(file);
	
		return fileName;
	}
	
	public boolean deleteFile(ServletContext servletContext, String path, FileDTO fileDTO) throws Exception {
		String realPath = servletContext.getRealPath(path);
		File file = new File(realPath, fileDTO.getFileName());
		System.out.println(realPath);
		
		return file.delete();
	}
}
