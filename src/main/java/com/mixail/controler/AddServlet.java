package com.mixail.controler;

import com.mixail.dbHelpers.AddQuery;
import com.mixail.model.Friends;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddServlet",urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//get the data
        String name= request.getParameter("name");
        String email= request.getParameter("email");
        int age= Integer.parseInt(request.getParameter("age"));
        String color = request.getParameter("color");
//set up a friend object
        Friends friends= new Friends();
        friends.setFriendName(name);
        friends.setAge(age);
        friends.setFavoriteColor(color);
        friends.setEmailAddr(email);
//set up a query object

        AddQuery addQuery = new AddQuery();
        addQuery.doAdd(friends);

        String url="/read";
        request.getRequestDispatcher(url).forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
