package com.mixail.dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadQuery {

    private Connection conn;
    private ResultSet resultSet;
    private UtilQuery utilQuery;

    public ReadQuery() {

        utilQuery = new UtilQuery();
        this.conn = utilQuery.getConn();
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

    public String getReadHTMLtable() throws SQLException {
        String table = "";
        table = utilQuery.getHTMLtable(resultSet);
        return table;


    }


}
