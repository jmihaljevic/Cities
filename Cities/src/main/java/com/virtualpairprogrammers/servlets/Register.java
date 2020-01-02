package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.Member;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/register")
public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        Member member = new Member(name,email,pass);
        try {
            member.createMember(member);
            RequestDispatcher rs = request.getRequestDispatcher("cities.jsp");
            rs.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}