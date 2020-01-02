package com.cities.servlets;

import com.cities.JDBCConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/cities/addCityToFavorites")
public class AddFavoriteCityInDatabase extends HttpServlet {
    private JDBCConnection jdbcConnection = JDBCConnection.getJdbcConnection();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String cityname = request.getParameter("cityName");
        HttpSession session=request.getSession(false);
        String email =(String) session.getAttribute("email");
        ResultSet rs = null;
        Integer cityId = null;
        Integer memberId = null;
        try {
            rs = jdbcConnection.execute("SELECT * FROM City where cityname = '" + cityname + "'");
            if (rs.next()) cityId = rs.getInt(1);
            rs = jdbcConnection.execute("SELECT * FROM member where email = '" + email + "'");
            if(rs.next()) memberId = rs.getInt(1);
            jdbcConnection.executeUpdate("insert into member_city (member_id, city_id) values (" + memberId + "," + cityId + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("/cities.jsp");
        rd.forward(request, response);
    }
}
