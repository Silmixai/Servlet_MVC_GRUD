package com.mixail.dbHelpers;

import com.mixail.model.Friends;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadRecord {
    private Connection conn;
    private ResultSet results;

    private Friends friend = new Friends();
    private int friendID;

    public ReadRecord(int frriendID) {
        UtilQuery utilQuery = new UtilQuery();
        this.conn = utilQuery.getConn();

        this.friendID = frriendID;

    }


    public void doRead() {

        String query = "SELECT * FROM friends WHERE friendsID =?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
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
