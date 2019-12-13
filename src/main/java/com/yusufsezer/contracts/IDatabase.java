package com.yusufsezer.contracts;

import java.sql.Connection;
import java.sql.ResultSet;

public interface IDatabase {

    Connection getConnection() throws Exception;

    ResultSet executeQuery(String query) throws Exception;

    Object executeSQL(String sql) throws Exception;

}
