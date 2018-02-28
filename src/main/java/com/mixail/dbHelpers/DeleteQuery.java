package com.mixail.dbHelpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DeleteQuery {
    private Connection conn;


    public DeleteQuery() {

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


    public void doDelete(int friendID) throws SQLException {

        String query = "DELETE FROM friends WHERE friendsID =?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,friendID);
        ps.executeUpdate();

    }

}
