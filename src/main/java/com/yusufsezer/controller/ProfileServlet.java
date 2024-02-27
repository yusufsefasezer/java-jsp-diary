package com.yusufsezer.controller;

import com.yusufsezer.model.User;
import com.yusufsezer.util.Helper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("user_id"));
        User foundUser = Helper.userRepository().get(userId);

        if (foundUser != null) {
            request.setAttribute("viewFile", "profile.jsp");
            request.setAttribute("pageTitle", foundUser.toString());
            request.setAttribute("diaryList", Helper.diaryRepository()
                    .getAllByUserId(userId, false));
        }

        Helper.view(request, response);
    }
}
