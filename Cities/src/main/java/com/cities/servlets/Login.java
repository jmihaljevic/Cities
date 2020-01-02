package com.cities.servlets;

import com.cities.FindUserName;
import com.cities.Validate;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/userLogin")
public class Login extends HttpServlet {

    private Validate validate = new Validate();
    private FindUserName findUserName = new FindUserName();

    private String name;
    private String email;
    private String pass;
    private boolean isAuthenticated = false;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        email = request.getParameter("email");
        pass = request.getParameter("pass");

        try {
            isAuthenticated = validate.checkUser(email, pass);
            name = findUserName.findUser(email,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (isAuthenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("email", email);
            session.setAttribute("pass", pass);
            session.setAttribute("isAuthenticated", isAuthenticated);
            RequestDispatcher rs = request.getRequestDispatcher("cities.jsp");
            rs.forward(request, response);
        } else {
            out.println("Username or Password incorrect");
            RequestDispatcher rs = request.getRequestDispatcher("citieslogin.jsp");
            rs.include(request, response);
        }
    }
}