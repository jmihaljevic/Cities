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

@WebServlet("/cities/removeFromFavorites")
public class RemoveFavoriteCityFromDatabase extends HttpServlet {

    private JDBCConnection jdbcConnection = JDBCConnection.getJdbcConnection();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String cityname = request.getParameter("removedCityName");
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
            jdbcConnection.executeUpdate("delete from member_city where member_id = " + memberId + " and city_id = " + cityId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("/cities.jsp");
        rd.forward(request, response);
    }
}
