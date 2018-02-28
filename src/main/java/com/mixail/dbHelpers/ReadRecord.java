package com.mixail.dbHelpers;

import com.mixail.model.Friends;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ReadRecord {
    private Connection conn;
    private ResultSet results;

    private Friends friend = new Friends();
    private int friendID;

    public ReadRecord(int frriendID) {

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

        this.friendID = frriendID;
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

        String query = "SELECT * FROM friends WHERE friendsID =?";

        try {
            PreparedStatement  ps = conn.prepareStatement(query);
            ps.setInt(1, friendID);
            this.results = ps.executeQuery();

                this.results.next();
                this.friend.setFriendId(this.results.getInt("friendsID"));
                this.friend.setFriendName(this.results.getString("friendName"));
                this.friend.setEmailAddr(this.results.getString("emailAddr"));
                this.friend.setAge(this.results.getInt("age"));
                this.friend.setFavoriteColor(this.results.getString("favoriteColor"));


            } catch (SQLException e) {
                e.printStackTrace();
            }






    }


    public Friends getFriend() {
        return friend;
    }

    public void setFriend(Friends friend) {
        this.friend = friend;
    }
}
