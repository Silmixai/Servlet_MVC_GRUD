package com.mixail.dbHelpers;

import com.mixail.model.Friends;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class SearchQuery {

    private Connection conn;
    private ResultSet resultSet;

    public SearchQuery() {
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

    public void doSearch(String friendName) {

        String query = "Select *FROM friends WHERE UPPER (friendName) Like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + friendName.toUpperCase() + "%");
            this.resultSet = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public String getHTMLtable() throws SQLException {
        String searchTable = "";
        searchTable += "<table border=1>";


        while (this.resultSet.next()) {
            Friends friend = new Friends();
            friend.setFriendId(this.resultSet.getInt("friendsID"));
            friend.setFriendName(this.resultSet.getNString("friendName"));
            friend.setEmailAddr(this.resultSet.getNString("emailAddr"));
            friend.setAge(this.resultSet.getInt("age"));
            friend.setFavoriteColor(this.resultSet.getString("favoriteColor"));
            searchTable += "<tr>";

            searchTable += "<td>";
            searchTable += friend.getFriendId();
            searchTable += "</td>";


            searchTable += "<td>";
            searchTable += friend.getFriendName();
            searchTable += "</td>";

            searchTable += "<td>";
            searchTable += friend.getEmailAddr();
            searchTable += "</td>";

            searchTable += "<td>";
            searchTable += friend.getAge();
            searchTable += "</td>";

            searchTable += "<td>";
            searchTable += friend.getFavoriteColor();
            searchTable += "</td>";

            searchTable += "<td>";
            searchTable += "<a href=update?friendID=" + friend.getFriendId() + "> Update </a>";
            searchTable += "</td>";


            searchTable += "<td>";
            searchTable += "<a href=delete?friendID=" + friend.getFriendId() + "> Delete </a>";
            searchTable += "</td>";

            searchTable += "</tr>";
        }

        searchTable += "</table>";
        return searchTable;

    }

}
