package com.bitacademy.myportal.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	//	파일 저장 위치
	private static String SAVE_PATH="d:/upload";
	
	public String store(MultipartFile mFile) {
		String saveFile = "";	//	저장할 이름
		String originalFilename = "";
		try {
			originalFilename = mFile.getOriginalFilename();
			Long size = mFile.getSize();
			String extName = 
				originalFilename.substring(originalFilename.lastIndexOf("."));
			System.out.println("원본 파일명:" + originalFilename);
			System.out.println("파일 사이즈:" + size);
			System.out.println("확장자:" + extName);
			
			saveFile = getSaveFilename(extName);
			System.out.println("저장할 파일명:" + saveFile);
			
			writeFile(mFile,saveFile);
		} catch(Exception e) {
			System.err.println("파일 저장 실패");
		}
		
		return saveFile;
	}

	private void writeFile(MultipartFile mFile, //	원본 멀티파트 파일
			String saveFilename) throws IOException {
		//	저장할 파일 바이너리
		byte[] fileData = mFile.getBytes();
		
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
		fos.write(fileData);
		fos.close();
	}
	private String getSaveFilename(String ext) {	//	확장자
		//	중복되지 않는 파일명
		Calendar cal = Calendar.getInstance();
		return String.valueOf(cal.getTimeInMillis() / 1000) + ext.toLowerCase();
	} 
}

