package com.liz.config;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CostomedConfig {

	ArrayList<String> properties = new ArrayList();
	
	public CostomedConfig() throws FileNotFoundException {
		
		File file = new File("config/config.properties");
		DataInputStream dis = new DataInputStream(new FileInputStream("config/config.properties"));
		try {
			Scanner sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String text;
		try {
			text = dis.readLine();
			System.out.println(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		while(sc.hasNext()) {
//			
//		}
		
		
		
		
		
		
//
//		try {
//			DataInputStream dis = new DataInputStream(new FileInputStream("config/config.properties"));
//			
//			String text = dis.readLine();
//			String[] properties = text.split("\r\n");
//			System.out.println(text);
//			

//			while (true) {
//				
//				String text = dis.readLine();
//				//System.out.println(text);
//				for(String value : text.split("\r\n"))
//				properties.add(value);
//				System.out.println(properties);// 텍스트 파일 내 데이터를 한 줄 씪 읽음
//				
//				// 무한 반복 현상을 막기 위해 텍스트 내 데이터가 없으면 ;끝내도록
//				if (text == null) {
//					break;
//				}
//				
//			}

//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}
}
