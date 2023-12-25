package com.yusufsezer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Initial {

	public static void main(String[] args) {
		
	    String containerName = "mysql-container";
	    String dataBase = "jspDiary";
	    String port = "3306";
	    String user = "root";
	    String password = "db-container-psw";	    
	    
	    String url = String.format("jdbc:mysql://%s:%s/%s", containerName, port, dataBase);

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("¡Conexión exitosa a la base de datos!");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
		
	}
}
