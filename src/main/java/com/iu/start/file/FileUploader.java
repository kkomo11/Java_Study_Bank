package com.iu.start.file;

import java.io.File;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

public class FileUploader {

	public String fileUploader(String realPath, MultipartFile photo) throws Exception {
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
