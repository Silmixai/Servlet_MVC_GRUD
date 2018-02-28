package com.mixail.dbHelpers;

import com.mixail.model.Friends;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class UpdateQuery {

    private Connection conn;

    public UpdateQuery() {

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
        String login = properties.getProperty("user.name");
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

    public void doUpdate(Friends friend) throws SQLException {
        String query = "UPDATE friends SET friendName=?,emailAddr=?,age=?,favoriteColor=? WHERE friendsID=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, friend.getFriendName());
        ps.setString(2, friend.getEmailAddr());
        ps.setInt(3, friend.getAge());
        ps.setString(4, friend.getFavoriteColor());
        ps.setInt(5, friend.getFriendId());
        ps.executeUpdate();

    }

}
