package com.wecareinsurance.wecareinsurance.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MySQLDataAccess implements DatabaseAccess {
    private static Connection CON;

    public MySQLDataAccess(String username, String password, String url) throws SQLException, ClassNotFoundException {
        this.initializeConnection(username, password, url);
    }

    @Override
    public Connection getConnection() {
        return CON;
    }

    @Override
    public List<HashMap<String, Object>> get(String query) throws SQLException {
        Statement stmt = CON.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<HashMap<String,Object>> records = new ArrayList<>();
        while (rs.next()) {
            HashMap<String, Object> row = new HashMap<>(columns);
            for(int i = 1; i <= columns; i++) {
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            records.add(row);
        }
        return records;
    }

    @Override
    public void insertOrUpdate(String query) throws SQLException {
        Statement stmt = CON.createStatement();
        stmt.executeUpdate(query);
    }

    @Override
    public String delete(String query, String identifier) throws SQLException {
        Statement stmt = CON.createStatement();
        stmt.executeUpdate(query);
        return identifier;
    }

    private void initializeConnection(String username, String password, String url) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        CON = DriverManager.getConnection(url, username, password);
    }
}
