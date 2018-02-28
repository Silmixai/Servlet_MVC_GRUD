package com.mixail.controler;

import com.mixail.dbHelpers.SearchQuery;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        try {

            String friendName = request.getParameter("searchVal");

            SearchQuery sq = new SearchQuery();
            sq.doSearch(friendName);
            String table = sq.getHTMLtable();
            request.setAttribute("table",table);
            request.getRequestDispatcher("/read.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);

    }
}
