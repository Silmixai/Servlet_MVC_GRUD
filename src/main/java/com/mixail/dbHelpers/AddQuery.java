package com.mixail.dbHelpers;

import com.mixail.model.Friends;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class AddQuery {
    private Connection conn;
    private ResultSet resultSet;

    public AddQuery() {

        UtilQuery utilQuery = new UtilQuery();
        this.conn = utilQuery.getConn();

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
