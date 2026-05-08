package com.the703.basic016_ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;

public class JavaIOEx001 {
	public static void main(String[] args) {
		//#1. 경로
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss"); //포맷설정
		long millis = System.currentTimeMillis();  // 시스템시간가져오기
		String folder_rel = "src/com/the703/basic016_ex/";  // 상대경로- 현재작업 폴더기준
		String file_path  = "app.log";
		
		File folder = new File(folder_rel);
		File file   = new File(file_path);
		//#2. 폴더+파일준비 (exists, mkdirs, createNewFile)
		try {
			if(!folder.exists()) {folder.mkdirs();}
			if(!file.exists()) {file.createNewFile();}
		}catch(Exception a) {a.printStackTrace();}
		
		//#3. char단위로 파일쓰기  Reader > [프로그램] > Writer
		//   sdf.format(millis) +  "로그파일입니다."	 20260508_1716 로그파일입니다.
		try {
			Writer writer = new FileWriter(file);
			writer.write(sdf.format(millis) +  "로그파일입니다.");
			writer.close();
		}catch(IOException a) {a.printStackTrace();}
		
		//#4. char단위로 파일읽기 Reader
		try {
			Reader reader = new FileReader(file);
			int cnt = 0;
			while( (cnt = reader.read()) != -1) {
				System.out.println((char)cnt);
			reader.close();
			}
		}catch(FileNotFoundException a) {a.printStackTrace();}
		catch(IOException a) {a.printStackTrace();}
		 
	}
}