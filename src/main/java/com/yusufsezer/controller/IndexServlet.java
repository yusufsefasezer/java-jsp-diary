package com.yusufsezer.controller;

import com.yusufsezer.util.Helper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("viewFile", "index.jsp");
        request.setAttribute("pageTitle", "Just Another Java JSP App...");
        request.setAttribute("diaryList", Helper.diaryRepository().getAll());
        request.setAttribute("userList", Helper.userRepository().getAll());
        Helper.view(request, response);
    }

}
