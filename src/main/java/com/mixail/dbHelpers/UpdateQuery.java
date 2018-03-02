package com.mixail.dbHelpers;

import com.mixail.model.Friends;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class UpdateQuery {

    private Connection conn;

    public UpdateQuery() {

        UtilQuery utilQuery = new UtilQuery();
        this.conn = utilQuery.getConn();
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
