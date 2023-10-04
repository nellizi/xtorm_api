package com.liz.appmain;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.liz.config.CostomedConfig;
import com.liz.ecmutils.XtormUtils;

public class AppMain {

	
//	public static void main(String[] args) throws IOException {
//		CostomedConfig con = new CostomedConfig();
//	}
//	
	
	public static void main(String[] args) {
		String filePath = null;
		String CC = null;
//		String elementId = null;
		Scanner sc = new Scanner(System.in);

		XtormUtils xtorm = new XtormUtils();

//		for (int i = 0; i < 10; i++) {
		filePath = sc.nextLine();
		CC = sc.nextLine();
		xtorm.create(filePath, CC);
//		}

//		xtorm.download(elementId);   //입력을 어디서 받아야 하지? main에서 호출할 때 입력하면 다른 변수들도 있어서 .. 한 개의 메서드만 호출 가능하게 해야하나?
		sc.close();
	}
}
