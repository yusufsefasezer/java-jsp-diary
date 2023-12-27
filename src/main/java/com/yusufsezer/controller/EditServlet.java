package com.yusufsezer.controller;
import com.yusufsezer.model.Diary;
import com.yusufsezer.util.Helper;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {

    private static final String REDIRECT_URL = "mydiaries";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
  
    	Integer diaryId = null;
    	
        try {
        	diaryId = Integer.parseInt(request.getParameter("diary_id"));
        } catch (NumberFormatException e){
        	e.printStackTrace();
        }
               
        Diary foundDiary = Helper.diaryRepository().get(diaryId);

        if (foundDiary != null) {
            request.setAttribute("viewFile", "edit.jsp");
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            request.setAttribute("pageTitle", "Edit diary / "
                    + sdf.format(foundDiary.getDateOfDiary()));
            request.setAttribute("diary", foundDiary);
            
            try {
				Helper.view(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
            
        } else {
        	
            try {
				response.sendRedirect(REDIRECT_URL);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
	
    	Integer diaryId = null;
    	
        try {
        	diaryId = Integer.parseInt(request.getParameter("diary_id"));
        } catch (NumberFormatException e){
        	e.printStackTrace();
        }
        
        Diary foundDiary = Helper.diaryRepository().get(diaryId);

        if (foundDiary != null) {
            String diaryContent = request.getParameter("diaryContent");
            boolean visible = request.getParameter("visible") != null;
            foundDiary.setContent(diaryContent);
            foundDiary.setVisibility(visible);

            Diary editResult = Helper.diaryRepository()
                    .update(foundDiary.getId(), foundDiary);

            if (editResult != null) {
                try {
					response.sendRedirect(REDIRECT_URL);
				} catch (IOException e) {
					e.printStackTrace();
				}
            } else {
                request.setAttribute("viewFile", "edit.jsp");
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                request.setAttribute("pageTitle", "Edit diary / "
                        + sdf.format(foundDiary.getDateOfDiary()));
                request.setAttribute("message", "Something went wrong");
                try {
					Helper.view(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
            }
        } else {
            try {
				response.sendRedirect(REDIRECT_URL);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }  
}
