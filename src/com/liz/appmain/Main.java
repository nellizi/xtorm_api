package com.liz.appmain;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	
	final static Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		logger.log(Level.ALL,"LOG TEST");
		logger.log(Level.ALL,"LOG TEST");
		logger.log(Level.ALL,"LOG TEST");
		
	}

}
