package com.cities.servlets;

import com.cities.JDBCConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/cities/addNewCity")
public class CreateCityInDatabase extends HttpServlet {
    private JDBCConnection jdbcConnection = JDBCConnection.getJdbcConnection();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String cityname = request.getParameter("cityname");
        String description = request.getParameter("description");
        int population = Integer.parseInt(request.getParameter("population"));

        try {
            jdbcConnection.executeUpdate("insert into city (cityname, description, population, CreatedDate)\n" +
                    "values ('" + cityname + "', '" + description + "', " + population + ", current_timestamp)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("/cities.jsp");
        rd.forward(request, response);
    }
}
