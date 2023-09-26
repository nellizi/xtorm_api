package com.liz.appmain;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class AppMain {

	public static void main(String[] args) {
		try {
		      DataInputStream dis = new DataInputStream(new FileInputStream("config/config.properties"));
		            
		        while(true) {
		            String text = dis.readLine();   
		            System.out.println(text);//텍스트 파일 내 데이터를 한 줄 씪 읽음
		            
		            //무한 반복 현상을 막기 위해 텍스트 내 데이터가 없으면 끝내도록
		            if(text == null) {
		                break;
		            }
		        }
		        
		    }catch(Exception e) {
		        e.printStackTrace();
		    }
		}
		 

	}
	
	
	
	
	
//	public static void main(String[] args) {
//		String filePath = null;
//		String CC = null;
//		String elementId = null;
//		Scanner sc = new Scanner(System.in);
//
//		XtormUtils xtorm = new XtormUtils();
//
////		for (int i = 0; i < 10; i++) {
//			filePath = sc.nextLine();
//			CC = sc.nextLine();
//			xtorm.create(filePath, CC);
////		}
//		
////		xtorm.download(elementId);   //입력을 어디서 받아야 하지? main에서 호출할 때 입력하면 다른 변수들도 있어서 .. 한 개의 메서드만 호출 가능하게 해야하나?
//	}


