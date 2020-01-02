package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.City;

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

@WebServlet("/cities/getAllCities")
public class GetAllCities extends HttpServlet {

    private City city = new City();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<City> cities = null;
        try {
            cities = city.getAllCities();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("cities", cities);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/allcities.jsp");
        dispatch.forward(request, response);

    }
}
