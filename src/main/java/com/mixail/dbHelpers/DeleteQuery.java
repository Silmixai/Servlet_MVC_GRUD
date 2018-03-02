package com.mixail.dbHelpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DeleteQuery {
    private Connection conn;


    public DeleteQuery() {

        UtilQuery utilQuery = new UtilQuery();
        this.conn = utilQuery.getConn();
    }


    public void doDelete(int friendID) throws SQLException {

        String query = "DELETE FROM friends WHERE friendsID =?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,friendID);
        ps.executeUpdate();

    }

}
