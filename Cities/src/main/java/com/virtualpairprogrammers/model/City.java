package com.virtualpairprogrammers.model;

import com.virtualpairprogrammers.JDBCConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class City {

    private JDBCConnection jdbcConnection = JDBCConnection.getJdbcConnection();

    private int id;
    private String cityName;
    private String description;
    private int population;
    private Timestamp creationDate;
    private int count;

    public City() {

    }
    public City(int id, String cityName, String description, int population, Timestamp creationDate) {
        this.id = id;
        this.cityName = cityName;
        this.description = description;
        this.population = population;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return  cityName +
                ", description: " + description + '\'' +
                ", population = " + population;
    }

    public List<City> getAllCities() throws SQLException {
        List<City> cities = new ArrayList<>();
        ResultSet rs = jdbcConnection.execute("SELECT * FROM City");
        while (rs.next()) {
            City city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getTimestamp(5));
            cities.add(city);
        }
        return cities;
    }

    public List<City> getSortedCitiesByCreatedDate() throws SQLException {
        List<City> sortedCities = new ArrayList<>();
        ResultSet rs = jdbcConnection.execute("SELECT * FROM City ORDER BY createddate");
        while (rs.next()) {
            City city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getTimestamp(5));
            sortedCities.add(city);
        }
        return sortedCities;
    }

    public List<City> getSortedCitiesByMembers() throws SQLException {
        List<City> sortedCities = new ArrayList<>();
        List<City> cities = getAllCities();
        ResultSet rs = jdbcConnection.execute("SELECT city_id, COUNT(*) FROM Member_City GROUP BY city_id ORDER BY COUNT(*) DESC;");
        while (rs.next()) {
            int cityId = rs.getInt(1);
            City city = cities.stream().filter(p -> p.getId()==cityId).findFirst().orElse(null);
            city.setCount(rs.getInt(2));
            sortedCities.add(city);
        }
        return sortedCities;
    }
}
