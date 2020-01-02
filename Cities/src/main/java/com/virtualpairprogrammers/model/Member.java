package com.virtualpairprogrammers.model;

import com.virtualpairprogrammers.JDBCConnection;

import java.sql.SQLException;

public class Member {

    private JDBCConnection jdbcConnection = JDBCConnection.getJdbcConnection();

    private String name;
    private String email;
    private String password;

    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void createMember(Member member) throws SQLException {
        jdbcConnection.executeUpdate("insert into member (name,email,pass) " +
                "values ('" + member.getName() + "', '" + member.getEmail() + "','" + member.getPassword() + "')");
    }
}
