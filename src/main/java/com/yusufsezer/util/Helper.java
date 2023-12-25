package com.yusufsezer.util;

import com.yusufsezer.contracts.IDatabase;
import com.yusufsezer.model.User;
import com.yusufsezer.repository.DiaryRepository;
import com.yusufsezer.repository.MySQL;
import com.yusufsezer.repository.UserRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.System.Logger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Helper {
	
	private Helper() {}
	
	public static final Logger logger = System.getLogger(Helper.class.getName());
	public static final String VIEW_FOLDER = "WEB-INF/view";
	public static final String NOT_FOUND = "notfound.jsp";
	private static IDatabase dataBase = null;
	
    public static void view(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String viewFile = getViewFile(request);
        request
                .getRequestDispatcher(Helper.VIEW_FOLDER + File.separator + viewFile)
                .forward(request, response);
    }

    private static String getViewFile(HttpServletRequest request) {
        Object viewFileAttribute = request.getAttribute("viewFile");
        return (viewFileAttribute == null)
                ? Helper.NOT_FOUND
                : viewFileAttribute.toString();
    }

    public static String getUrlDatabase() {  
    	
    	Properties prop = new Properties();
    	String url = null;
    	
    	try (InputStream input = new FileInputStream("./config.properties")) { 		
    	    prop.load(input);
    	    
    	    final String PORT = prop.getProperty("db.port");
    	    final String USER = prop.getProperty("db.user");
    	    final String PASSWORD = prop.getProperty("db.password");
    	    final String COINTAINER_DB = prop.getProperty("db.containerName");
    	    
    	    url = String.format("jdbc:mysql://mysql-container:%s/%s?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&user=%s&password=%s&useUnicode=true&characterEncoding=UTF-8"
    	    		,PORT, COINTAINER_DB, USER, PASSWORD);  	
    	    
    	    System.out.println(url);
           
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}  

    	return "jdbc:mysql://mysql-container:3306/jspDiary?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&user=root&password=db-psw&useUnicode=true&characterEncoding=UTF-8"; 
    }

    private static IDatabase getMySQLDatabase() {
        if (Helper.dataBase == null) {
            Helper.dataBase = new MySQL(Helper.getUrlDatabase());
        }

        return Helper.dataBase;
    }

    public static UserRepository userRepository() {
        return new UserRepository(Helper.getMySQLDatabase());
    }

    public static DiaryRepository diaryRepository() {
        return new DiaryRepository(Helper.getMySQLDatabase());
    }

    public static boolean checkParameters(String[] parameters, Map<String, String[]> parameterMap) {
        for (String parameter : parameters) {
            if (!parameterMap.containsKey(parameter)) {
                return false;
            }
        }
        return true;
    }

    public static String md5(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(text.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return text;
        }
    }

    public static User getLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object userAttribute = session.getAttribute("user");
        return userAttribute == null ? null : (User) userAttribute;
    }
}