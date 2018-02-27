package com.mixail.dbHelpers;

import com.mixail.model.Friends;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ReadQuery {

    private Connection conn;
    private ResultSet resultSet;

    public ReadQuery() {
        Properties properties = new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("C:\\Users\\Mike\\Documents\\Servlet_MVC\\src\\main\\resources\\dbConn.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // FileInputStream inputStream = getClass().getResourceAsStream("dbConn.properties");
        String login = (String) properties.getProperty("user.name");
        String password = properties.getProperty("user.password");
        String url = properties.getProperty("server.name");
        String driver = properties.getProperty("driver.name");
        System.out.println("login=" + login);
        System.out.println("password=" + password);
        System.out.println("uri=" + url);
        System.out.println("driver=" + driver);



        try {
            Class.forName(properties.getProperty("driver.name"));
            conn = DriverManager.getConnection(url + "?useSSL=false", login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void doRead() {
        String query = "Select *from friends";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            this.resultSet = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getHTMLtable() throws SQLException {
        String table = "";
        table += "<table border=1>";


            while (this.resultSet.next()) {
                Friends friend = new Friends();
                friend.setFriendId(this.resultSet.getInt("friendsID"));
                friend.setFriendName(this.resultSet.getNString("friendName"));
                friend.setEmailAddr(this.resultSet.getNString("emailAddr"));
                friend.setAge(this.resultSet.getInt("age"));
                friend.setFavoriteColor(this.resultSet.getString("favoriteColor"));
                table += "<tr>";

                table += "<td>";
                table += friend.getFriendId();
                table += "</td>";


                table += "<td>";
                table += friend.getFriendName();
                table += "</td>";

                table += "<td>";
                table += friend.getEmailAddr();
                table += "</td>";

                table += "<td>";
                table += friend.getAge();
                table += "</td>";

                table += "<td>";
                table += friend.getFavoriteColor();
                table += "</td>";

                table += "</tr>";
            }

            table += "</table>";
            return table;


        }




}
