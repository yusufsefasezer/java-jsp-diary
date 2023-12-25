package com.yusufsezer;

import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;

public class Initial {

	public static void main(String[] args) {
		
    	Properties prop = new Properties();
    	String url = null;
    	
    	try (InputStream input = new FileInputStream("./config.properties")) { 		
    	    prop.load(input);
    	    
    	    final String PORT = prop.getProperty("db.port");
    	    final String USER = prop.getProperty("db.user");
    	    final String PASSWORD = prop.getProperty("db.password");
    	    final String COINTAINER_DB = prop.getProperty("db.containerName");
    	    
    	    url = String.format("jdbc:mysql://mysql-container:%s/%s?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&user=%s&password=%s&useUnicode=true&characterEncoding=UTF-8"
    	    		,PORT, COINTAINER_DB, USER, PASSWORD);  	
    	    
    	    System.out.println(url);
           
    	} catch (IOException e) {
    	    e.printStackTrace();
    	} 		
	}
}
