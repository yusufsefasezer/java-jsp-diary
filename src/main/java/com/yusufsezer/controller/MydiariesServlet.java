package com.yusufsezer.controller;

import com.yusufsezer.model.User;
import com.yusufsezer.util.Helper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
