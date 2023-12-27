package com.yusufsezer.controller;

import com.yusufsezer.util.Helper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("viewFile", "index.jsp");
            request.setAttribute("pageTitle", "Just Another Java JSP App...");
            request.setAttribute("diaryList", Helper.diaryRepository().getAll());
            request.setAttribute("userList", Helper.userRepository().getAll());
            Helper.view(request, response);
        } catch (FileNotFoundException e) {
            // Handle the FileNotFoundException here
            // For example, you can log the error or show an error message to the user
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while accessing the diary repository.");
        } catch (ServletException | IOException e) {
            // Handle the ServletException and IOException here
            // For example, you can log the error or show an error message to the user
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
        }
    }

}
