package com.mixail.controler;

import com.mixail.dbHelpers.ReadRecord;
import com.mixail.model.Friends;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateFormServlet", urlPatterns = "/update")
public class UpdateFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int friendId = Integer.parseInt(request.getParameter("friendID"));

        ReadRecord rr = new ReadRecord(friendId);
        rr.doRead();
        final Friends friend = rr.getFriend();
        request.setAttribute("friend",friend);
        String url = "/updateForm.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
