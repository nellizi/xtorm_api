package com.liz.ecmutils;

import java.util.Scanner;

import com.liz.config.Config;
import com.windfire.apis.asysConnectData;
import com.windfire.apis.asys.asysUsrElement;

public class XtormUtils {

	Config conf = new Config();
	public asysConnectData con = new asysConnectData(conf.hostname, Integer.parseInt(conf.port), conf.descr,conf.username, conf.password);
	public asysUsrElement uePage1 = new asysUsrElement(con);
	public String gateway = conf.gateway;
	Scanner sc = new Scanner(System.in);
	

	/*  
	public asysConnectData con = null;
	
	public XtormUtils() {
		Config conf = new Config();
		con = new asysConnectData(conf.hostname, Integer.parseInt(conf.port), conf.descr, conf.username, conf.password);
	}
	*/

	public int create(String filePath, String CC) {

//		asysUsrElement uePage1 = new asysUsrElement(con);
		uePage1.m_localFile = filePath;
		uePage1.m_descr = "ScanedImage";
		uePage1.m_cClassId = CC;
		uePage1.m_userSClass = "NONE";
		uePage1.m_eClassId = "IMAGE";
		
		int ret = uePage1.create(gateway);
		
		if (ret != 0) {
			System.out.println("Error, create normal, " + uePage1.getLastError());
			
		}else {
			System.out.println("Success, create normal, " + uePage1.m_elementId);
		}
		
		discon();

		return ret;
	}

	public int download(String localPath, String elementId) {

//		asysUsrElement uePage1 = new asysUsrElement(con);
		String content = localPath + elementId +".txt";
//		uePage1.m_elementId = gateway + "::" + elementId + "::IMAGE";

		int ret = uePage1.getContent("C:\\XTORMTEST\\2023100322423100");
		
		if (ret != 0) {
			System.out.println("Error, download normal, " + uePage1.getLastError());
		}else {
			System.out.println("Success, download normal, " + uePage1.m_elementId);
		}
		
		discon();
		return ret;

	}
	
	
	
	public int download() {

//		asysUsrElement uePage1 = new asysUsrElement(con);
		String elementId = sc.nextLine();
		String localPath = conf.localPath;
		System.out.println(localPath);
		String content = localPath + elementId;
		uePage1.m_elementId = gateway + "::" + elementId + "::IMAGE";

		int ret = uePage1.getContent(content);
		
		if (ret != 0) {
			System.out.println("Error, download normal, " + uePage1.getLastError());
		}else {
			System.out.println("Success, download normal, " + uePage1.m_elementId);
		}
		
		discon();
		return ret;

	}
	
	
	
	public int delete(String elementId) {
		uePage1.m_elementId = gateway + "::" + elementId +"::IMAGE";
		int ret = uePage1.delete();
		
		if(ret != 0) {
			System.out.println("Error, fail to felete," + uePage1.getLastError());
		}else {
			System.out.println("Success,delete is done," + uePage1.m_elementId);
		}
		
		return ret;
	}

	public void discon() {
		if (con != null) {
			con.close();
			con = null;
		}
	}

}
