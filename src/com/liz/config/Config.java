package com.liz.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	public String hostname;
	public String port;
	public String descr;
	public String username;
	public String password;

	public Config() {

		String addr = "config/config.properties";

		Properties prop = new Properties();

		try {
			prop.load(new FileInputStream(addr));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.hostname = prop.getProperty("hostname");
		this.port = prop.getProperty("port");
		this.descr = prop.getProperty("descr");
		this.username = prop.getProperty("username");
		this.password = prop.getProperty("password");
	}

	
	
	
	
	
	
	
	
}
