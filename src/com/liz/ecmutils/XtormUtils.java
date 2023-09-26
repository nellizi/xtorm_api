package com.liz.ecmutils;

import com.liz.config.Config;
import com.windfire.apis.asysConnectData;
import com.windfire.apis.asys.asysUsrElement;

public class XtormUtils {

	Config conf = new Config();
	public asysConnectData con = new asysConnectData(conf.hostname, Integer.parseInt(conf.port), conf.descr,
			conf.username, conf.password);

	public asysUsrElement uePage1 = new asysUsrElement(con);

//	public asysConnectData con = null;

//	public XtormUtils() {
//		Config conf = new Config();
//		con = new asysConnectData(conf.hostname, Integer.parseInt(conf.port), conf.descr, conf.username, conf.password);
//	}

	public void create(String filePath, String CC) {

//		asysUsrElement uePage1 = new asysUsrElement(con);
		uePage1.m_localFile = filePath;
		uePage1.m_descr = "ScanedImage";
		uePage1.m_cClassId = CC;
		uePage1.m_userSClass = "NONE";
		uePage1.m_eClassId = "IMAGE";

		for (int i = 0; i < 10; i++) {
			int ret = uePage1.create("XTORM_MAIN");
			if (ret != 0)
				System.out.println("Error, create normal, " + uePage1.getLastError());
			else
				System.out.println("Success, create normal, " + uePage1.m_elementId);
		}
		discon();
	}

	public void download(String elementId) {

//		asysUsrElement uePage1 = new asysUsrElement(con);
		String content = "D:/temp/"+elementId+".txt";
		uePage1.m_elementId = "XTORM_MAIN::" + elementId + "::IMAGE";
		int ret = uePage1.getContent(content);
		if (ret != 0)
			System.out.println("Error, download normal, " + uePage1.getLastError());
		else
			System.out.println("Success, download normal, " + uePage1.m_elementId);
		
	}

	
	public void discon() {
		if (con != null) {
			con.close();
			con = null;
		}
	}

}
