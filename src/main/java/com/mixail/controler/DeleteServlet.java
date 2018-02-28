package com.mixail.controler;

import com.mixail.dbHelpers.DeleteQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteServlet", urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int friendId = Integer.parseInt(request.getParameter("friendID"));
        DeleteQuery deleteQuery = new DeleteQuery();
        try {
            deleteQuery.doDelete(friendId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String url="/read";
        request.getRequestDispatcher(url).forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
