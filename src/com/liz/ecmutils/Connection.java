//package com.liz.ecmutils;
//
//import com.liz.config.Config;
//import com.windfire.apis.asysConnectData;
//
//public class Connection {
//
//	public asysConnectData con = null;
//
//	public Connection() {
//		Config conf = new Config();
//		con = new asysConnectData(conf.hostname, Integer.parseInt(conf.port), conf.descr, conf.username, conf.password);
//	}
//
//	public void discon() {
//		if (con != null) {
//			con.close();
//			con = null;
//		}
//	}
//}
