package com.yusufsezer.controller;

import com.yusufsezer.model.User;
import com.yusufsezer.util.Helper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mydiaries")
public class MydiariesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User loginUser = Helper.getLoginUser(request);
        request.setAttribute("viewFile", "mydiaries.jsp");
        request.setAttribute("pageTitle", "My diaries");
        request.setAttribute("diaryList", Helper.diaryRepository()
                .getAllByUserId(loginUser.getId(), true));
        Helper.view(request, response);
    }
}
