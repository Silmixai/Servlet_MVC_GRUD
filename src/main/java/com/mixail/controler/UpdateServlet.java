package com.mixail.controler;

import com.mixail.dbHelpers.UpdateQuery;
import com.mixail.model.Friends;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateServlet", urlPatterns = "/updateFriend")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int friendId = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String color = request.getParameter("color");


        Friends friend = new Friends();
        friend.setFriendId(friendId);
        friend.setFriendName(name);
        friend.setAge(age);
        friend.setEmailAddr(email);
        friend.setFavoriteColor(color);

        UpdateQuery uq = new UpdateQuery();
        try {
            uq.doUpdate(friend);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String url = "/read";
        request.getRequestDispatcher(url).forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
