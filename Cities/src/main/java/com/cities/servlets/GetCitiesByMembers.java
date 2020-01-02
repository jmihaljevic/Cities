package com.cities.servlets;

import com.cities.model.City;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/cities/sortedByMembers")
public class GetCitiesByMembers extends HttpServlet {

    private City city = new City();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<City> sortedCities = null;
        try {
            sortedCities = city.getSortedCitiesByMembers();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("sortedCities", sortedCities);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/sortedCitiesByMembers.jsp");
        dispatch.forward(request, response);

    }
}
