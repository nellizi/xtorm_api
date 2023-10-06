package com.liz.ecmutils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.liz.config.Config;

public class LogUtils {

	Config conf = new Config();
	String logPath = conf.logPath;
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

	String date = now.format(dtf);

	File file = new File(logPath + "\\" + date + ".txt");


	/*
	 * 1. 로그 파일 생성될 dir 확인 -> properties에서 불러오기
	 * 
	 */

	public LogUtils() {
		File dir = new File(logPath);
		if (!dir.exists()) {
			dir.mkdir();
		}
	}

	public void logWrite(String msg) {

		try {
			System.out.println("create log");

			FileWriter filewriter = new FileWriter(file,true);
			BufferedWriter writer = new BufferedWriter(filewriter);
			writer.write("\r\n"+msg);
			writer.close();

		} catch (IOException e) {
			
		}

	}

	public void errorWrite(String msg) {
		try {
			System.out.println("error log");

			FileWriter filewriter = new FileWriter(file,true);
			BufferedWriter writer = new BufferedWriter(filewriter);
			writer.write("\r\n"+msg);
			writer.close();

		} catch (IOException e) {

		}

	}

}
