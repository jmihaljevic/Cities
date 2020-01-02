package com.cities.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cities/userLogout")
public class Logout extends HttpServlet {
    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        session.setAttribute("isAuthenticated", false);
        RequestDispatcher rs = request.getRequestDispatcher("/cities.jsp");
        rs.forward(request, response);
    }
}
