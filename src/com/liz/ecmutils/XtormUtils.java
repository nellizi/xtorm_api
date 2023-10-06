package com.liz.ecmutils;

import java.util.Scanner;

import com.liz.config.Config;
import com.windfire.apis.asysConnectData;
import com.windfire.apis.asys.asysUsrElement;

public class XtormUtils {

	public Config conf = new Config();
	public LogUtils log = new LogUtils();
	public asysConnectData con = new asysConnectData(conf.hostname, Integer.parseInt(conf.port), conf.descr,conf.username, conf.password);
	public asysUsrElement uePage1 = new asysUsrElement(con);
	public Scanner sc = new Scanner(System.in);
	public String gateway = conf.gateway;

	/*
	 * public asysConnectData con = null;
	 * 
	 * public XtormUtils() { Config conf = new Config(); 
	 * con = new asysConnectData(conf.hostname, Integer.parseInt(conf.port), conf.descr,conf.username, conf.password); 
	 * 
	 * }
	 */

	public int create() {
		
		System.out.println("등록 파일 입력: ");
		uePage1.m_localFile = sc.nextLine();
		System.out.println("CC 입력: ");
		uePage1.m_cClassId = sc.nextLine();
		uePage1.m_descr = "ScanedImage";
		uePage1.m_userSClass = "NONE";
		uePage1.m_eClassId = "IMAGE";

		int ret = uePage1.create(gateway);

		if (ret != 0) {
			String msg = "Error, fail to create, " + uePage1.getLastError();
			log.errorWrite(msg);

		} else {
			String msg = "Success, create normal, " + uePage1.m_elementId;
			log.logWrite(msg);
		}

		sc.close();
		discon();

		return ret;
		
	}

	
	public int create(String filePath, String CC) {

//		asysUsrElement uePage1 = new asysUsrElement(con);
		uePage1.m_localFile = filePath;
		uePage1.m_descr = "ScanedImage";
		uePage1.m_cClassId = CC;
		uePage1.m_userSClass = "NONE";
		uePage1.m_eClassId = "IMAGE";

		int ret = uePage1.create(gateway);

		if (ret != 0) {
			String msg = "Error, fail to create, " + uePage1.getLastError();
			log.errorWrite(msg);

		} else {
			String msg = "Success, create normal, " + uePage1.m_elementId;
			log.logWrite(msg);
		}

		sc.close();
		discon();

		return ret;
	}

	public int download(String localPath, String elementId) {

//		asysUsrElement uePage1 = new asysUsrElement(con);
		String content = localPath + elementId ;
//		uePage1.m_elementId = gateway + "::" + elementId + "::IMAGE";

		int ret = uePage1.getContent(content);

		if (ret != 0) {
			String msg = "Error, fail to download, " + uePage1.getLastError();
			log.errorWrite(msg);
		} else {
			String msg = "Success, download normal, " + uePage1.m_elementId;
			log.logWrite(msg);
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
			String msg = "Error, fail to download, " + uePage1.getLastError();
			System.out.println(msg);
			log.errorWrite(msg);
			
		} else {
			String msg = "Success, download normal, " + uePage1.m_elementId;
			System.out.println(msg);
			log.logWrite(msg);
		}

		discon();
		return ret;

	}

	public int delete(String elementId) {
		uePage1.m_elementId = gateway + "::" + elementId + "::IMAGE";
		int ret = uePage1.delete();

		if (ret != 0) {
			String msg = "Error, fail to felete," + uePage1.getLastError();
			log.errorWrite(msg);
		} else {
			String msg = "Success,delete is done," + uePage1.m_elementId;
			log.logWrite(msg);
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
