package com.yusufsezer.repository;

import com.yusufsezer.contracts.IDatabase;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL implements IDatabase {

    private final String source;
	public static final  Logger logger = System.getLogger(MySQL.class.getName());
    public MySQL(String source) {
        this.source = source;
    }

    @Override
    public Connection getConnection() {     
    	
    	Connection connection = null;
    	
        try {        
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	connection = DriverManager.getConnection(source);          	
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            logger.log(System.Logger.Level.INFO, connection == null ? "Connection is null" : "Connection accepted");
		}
        
        return null;
    }

    @Override
    public ResultSet executeQuery(String query) {
        try {
			return getConnection().createStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public Object executeSQL(String sql) {
        try {
			return getConnection().createStatement().execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
    }
}