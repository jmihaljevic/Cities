package com.virtualpairprogrammers.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cities/createCity")
public class CreateCity extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        Boolean isAuthenticated =(Boolean) session.getAttribute("isAuthenticated");
        if(isAuthenticated) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatch = context.getRequestDispatcher("/createcity.jsp");
            dispatch.forward(request, response);
        }
    }
}
