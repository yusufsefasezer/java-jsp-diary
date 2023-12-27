package com.yusufsezer.controller;
import com.yusufsezer.util.Helper;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("viewFile", "index.jsp");
            request.setAttribute("pageTitle", "Just Another Java JSP App...");
            request.setAttribute("diaryList", Helper.diaryRepository().getAll());
            request.setAttribute("userList", Helper.userRepository().getAll());
            Helper.view(request, response);
        } catch (FileNotFoundException e) {
            e.printStackTrace();        
            
            try {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while accessing the diary repository.");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        
        } catch (ServletException | IOException e) {
        	
            e.printStackTrace();
            
            try {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        }
    }
}
