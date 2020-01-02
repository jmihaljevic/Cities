package com.virtualpairprogrammers;

import java.sql.*;

public class Validate {

    private JDBCConnection jdbcConnection = JDBCConnection.getJdbcConnection();

    public boolean checkUser(String email,String pass) throws SQLException {
        boolean st =false;
        ResultSet rs = jdbcConnection.execute("select * from member where email = '" + email + "' and pass = '" + pass + "'");
        if(rs.next()) st = true;
        return st;
    }
}
