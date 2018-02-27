package com.mixail.controler;

import com.mixail.dbHelpers.ReadQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class ReadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReadQuery readQuery = new ReadQuery();
        readQuery.doRead();
        try {
            String table = readQuery.getHTMLtable();
            request.setAttribute("table", table);
            String url = "/read.jsp";
            request.getRequestDispatcher(url).forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
