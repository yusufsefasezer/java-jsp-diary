package com.yusufsezer.controller;

import com.yusufsezer.model.Diary;
import com.yusufsezer.model.User;
import com.yusufsezer.util.Helper;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("viewFile", "add.jsp");
        DateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        request.setAttribute("pageTitle", "Add new diary / "
                + sdf.format(new Date()));
        Helper.view(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User loginUser = Helper.getLoginUser(request);
        String diaryContent = request.getParameter("diaryContent");
        boolean visible = request.getParameter("visible") != null;

        Diary newDiary = new Diary();
        newDiary.setUserId(loginUser.getId());
        newDiary.setDateOfDiary(new Date());
        newDiary.setContent(diaryContent);
        newDiary.setVisibility(visible);

        boolean addResult = Helper.diaryRepository().add(newDiary);
        if (!addResult) {
            request.setAttribute("viewFile", "add.jsp");
            DateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
            request.setAttribute("pageTitle", "Add new diary / "
                    + sdf.format(new Date()));
            request.setAttribute("message", "Something went wrong");
            Helper.view(request, response);
        } else {
            response.sendRedirect("mydiaries");
        }

    }
}
