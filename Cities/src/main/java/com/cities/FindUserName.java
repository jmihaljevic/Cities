package com.cities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FindUserName {

    private JDBCConnection jdbcConnection = JDBCConnection.getJdbcConnection();

    public String findUser(String email, String pass) throws SQLException {
        boolean st =false;
        ResultSet rs = jdbcConnection.execute("select * from member where email = '" + email + "' and pass = '" + pass + "'");
        if(rs.next()) return rs.getString(2);
        return null;
    }
}
