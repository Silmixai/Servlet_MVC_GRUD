package com.mixail.dbHelpers;

import com.mixail.model.Friends;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class UtilQuery {

    private Connection conn;
    private String login;
    private String password;
    private String url;
    private String driver;

    public Connection getConn() {
        return conn;
    }


    public UtilQuery() {
        Properties properties = new Properties();
        FileInputStream fileInputStream;
        try {
            InputStream inputStream;
            inputStream = getClass().getResourceAsStream("/dbConn.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.login = (String) properties.getProperty("user.name");
        this.password = properties.getProperty("user.password");
        this.url = properties.getProperty("server.name");
        this.driver = properties.getProperty("driver.name");

        try {
            Class.forName(properties.getProperty("driver.name"));
            conn = DriverManager.getConnection(url + "?useSSL=false", login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public String getHTMLtable(ResultSet resultSet) throws SQLException {
        String table = "";
        table += "<table border=1>";

        while (resultSet.next()) {
            Friends friend = new Friends();
            friend.setFriendId(resultSet.getInt("friendsID"));
            friend.setFriendName(resultSet.getNString("friendName"));
            friend.setEmailAddr(resultSet.getNString("emailAddr"));
            friend.setAge(resultSet.getInt("age"));
            friend.setFavoriteColor(resultSet.getString("favoriteColor"));
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

            table += "<td>";
            table += "<a href=update?friendID=" + friend.getFriendId() + "> Update </a>";
            table += "</td>";


            table += "<td>";
            table += "<a href=delete?friendID=" + friend.getFriendId() + "> Delete </a>";
            table += "</td>";


            table += "</tr>";
        }

        table += "</table>";
        return table;


    }



}
