package com.yusufsezer.repository;

import com.yusufsezer.contracts.IDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL implements IDatabase {

    private final String source;

    public MySQL(String source) {
        this.source = source;
    }

    @Override
    public Connection getConnection() {       
    	Connection connection = null;
        try {        
        	Class.forName("com.mysql.jdbc.Driver");
        	connection = DriverManager.getConnection(source);    
        	
        	if (connection != null) {
        		System.out.println("No es null");
        	}
        	
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        return null;
    }

    @Override
    public ResultSet executeQuery(String query)
            throws SQLException, ClassNotFoundException {
        return getConnection().createStatement().executeQuery(query);
    }

    @Override
    public Object executeSQL(String sql)
            throws SQLException, ClassNotFoundException {
        return getConnection().createStatement().execute(sql);
    }
}