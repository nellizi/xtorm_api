package com.liz.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CostomedConfig {

//	ArrayList<String> properties = new ArrayList();
	
	public CostomedConfig() throws IOException {

		File file = new File("config/config.properties");
		String[]properties = new String[5];
            //입력 스트림 생성ㅁ
            FileReader filereader = new FileReader(file);
            int singleCh = 0;
            while((singleCh = filereader.read()) != -1){
            	String value = String.valueOf((char)singleCh);
                System.out.print(value);
                properties[0]=value;
                System.out.println(properties);
            }
//            System.out.println();
            filereader.close();
			
//			while (true) {
//				
//				String text = dis.readLine();
//				//System.out.println(text);
//				for(String value : text.split("\r\n"))
//				properties.add(value);
//				System.out.println(properties.get(0));// 텍스트 파일 내 데이터를 한 줄 씪 읽음
//				
//				// 무한 반복 현상을 막기 위해 텍스트 내 데이터가 없으면 ;끝내도록
//				if (text == null) {
//					break;
//				}
//				
//			}
//
			


	}
}
