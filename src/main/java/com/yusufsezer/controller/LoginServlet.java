package com.yusufsezer.controller;

import com.yusufsezer.model.User;
import com.yusufsezer.util.Helper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("viewFile", "login.jsp");
        request.setAttribute("pageTitle", "Login");
        Helper.view(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] parameters = {"email", "password"};
        boolean checkResult = Helper
                .checkParameters(parameters, request.getParameterMap());

        if (!checkResult) {
            request.setAttribute("viewFile", "login.jsp");
            request.setAttribute("message", "Please fill all field");
            Helper.view(request, response);
        } else {

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User user = Helper.userRepository()
                    .login(email, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("mydiaries");
            } else {
                request.setAttribute("message", "No user found.");
                request.setAttribute("viewFile", "login.jsp");
                request.setAttribute("pageTitle", "Login");
                Helper.view(request, response);
            }
        }

    }
}
