package com.mixail.dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchQuery {

    private Connection conn;
    private ResultSet resultSet;
    private UtilQuery utilQuery;

    public SearchQuery() {
        utilQuery = new UtilQuery();
        this.conn = utilQuery.getConn();

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


    public String getSearchHTMLtable() throws SQLException {
        String searchTable = "";
        searchTable = utilQuery.getHTMLtable(resultSet);
        return searchTable;

    }

}
