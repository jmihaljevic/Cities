package com.cities;

import java.sql.*;

public class JDBCConnection {

    private final String url = "jdbc:postgresql://127.0.0.1:5432/Cities";
    private final String user = "postgres";
    private final String password = "1909";

    private static final JDBCConnection jdbcConnection = new JDBCConnection();
    private JDBCConnection() {}
    public static JDBCConnection getJdbcConnection() {
        return jdbcConnection;
    }

    private Connection conn = null;

    private Connection connect() {
        try {
            if (conn != null) {
                return conn;
            }
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public ResultSet execute(String command) throws SQLException {
        Statement statement = null;
        try {
            statement = connect().createStatement();
            return statement.executeQuery(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String command) throws SQLException {
        Statement statement = null;
        try {
            statement = connect().createStatement();
            statement.executeUpdate(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
