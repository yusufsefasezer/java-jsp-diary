package com.yusufsezer.repository;

import com.yusufsezer.contracts.IDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MySQL implements IDatabase {

    public MySQL() {}

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException, FileNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
             
    	Properties prop = new Properties();
 	
    	try (InputStream input = new FileInputStream(System.getProperty("user.dir") + "/config.properties")) { 		
    	    prop.load(input);
    	    
    	    String containerName = "mysql-container";
    	    String dataBase = "jspDiary";
    	    String port = "3306";
    	    String user = "root";
    	    String password = "db-container-psw";	    
    	    
    	    String url = String.format("jdbc:mysql://%s:%s/%s", containerName, port, dataBase);
    	   	    
    	    return DriverManager.getConnection(url, user, password);
           
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}
        
        return null;   
    }

    @Override
    public ResultSet executeQuery(String query) throws SQLException, ClassNotFoundException, FileNotFoundException {           	
    	return getConnection().createStatement().executeQuery(query);           
    }

    @Override
    public Object executeSQL(String sql) throws SQLException, ClassNotFoundException, FileNotFoundException {
        return getConnection().createStatement().execute(sql);
    }
}
