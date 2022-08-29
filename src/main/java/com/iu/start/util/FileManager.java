package com.iu.start.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	@Autowired
	private ServletContext servletContext;

	public String saveFile(String path, MultipartFile photo) throws Exception {
		String realPath = servletContext.getRealPath(path);
		File file = new File(realPath);
		String fileName=null;
		if(!file.exists()) file.mkdirs();
		if(!photo.isEmpty()) {
			fileName = UUID.randomUUID().toString();
			fileName = fileName+"_"+photo.getOriginalFilename();
			file = new File(file, fileName);
			photo.transferTo(file);
		}
		return fileName;
	}
}
