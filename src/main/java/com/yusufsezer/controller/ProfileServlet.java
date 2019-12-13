package com.yusufsezer.controller;

import com.yusufsezer.util.Helper;
import com.yusufsezer.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
