package com.mixail.dbHelpers;

import com.mixail.model.Friends;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class AddQuery {
    private Connection conn;
    private ResultSet resultSet;

    public AddQuery() {

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
        String login = (String) properties.getProperty("user.name");
        String password = properties.getProperty("user.password");
        String url = properties.getProperty("server.name");
        String driver = properties.getProperty("driver.name");

        try {
            Class.forName(properties.getProperty("driver.name"));
            conn = DriverManager.getConnection(url + "?useSSL=false", login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void doAdd(Friends friend) {

        String query = "INSERT INTO friends (friendName,emailAddr,age,favoriteColor) VALUES(?,?,?,?)";
        PreparedStatement ps= null;
        try {
            ps = conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.setString(1,friend.getFriendName());
            ps.setString(2,friend.getEmailAddr());
            ps.setInt(3,friend.getAge());
            ps.setString(4,friend.getFavoriteColor());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
