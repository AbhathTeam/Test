package com.acd.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.acd.conn.DBUtils;
import com.acd.conn.MyUtils;
import com.acd.modal.Suggition;
import com.acd.modal.UserAccount;

@WebServlet(urlPatterns = { "/userList"})
public class UserListView extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6318699493277483516L;
	public UserListView() {
		super();
	}
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		  Connection conn = MyUtils.getStoredConnection(request);
		  HttpSession session = request.getSession();
			 UserAccount userAccount = MyUtils.getLoginedUser(session);
			 String userType = request.getParameter("userType");
	        String errorString = null;
	        List<UserAccount> list = null;
	        try {
	            list = DBUtils.findUserList(conn,userType);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        redirectRequestedUrl(userType, request, response, errorString, list);
	        
	    }
	  private void redirectRequestedUrl(String userType,HttpServletRequest request,HttpServletResponse response,String errorString,List<UserAccount> list) throws ServletException, IOException {
	    	
	    	String redirectUrl = "userRegistration.jsp";
	    	if("ROLE_CITIZEN".equals(userType)) {
	    		redirectUrl = "userRegistration.jsp";
	    	}else if("ROLE_OFFICER".equals(userType)) {
	    		 redirectUrl = "officersDetails.jsp";
	    	}else if("ROLE_NGO".equals(userType)) {
	    		 redirectUrl = "ngoForm.jsp";
	    	}else {
	    		 redirectUrl = "adminLogin.jsp";
	    	}
	    	 request.setAttribute("usersList", list);
	    	   request.setAttribute("errorString", errorString);
	    	  RequestDispatcher dispatcher //
	          = request.getServletContext().getRequestDispatcher("/WEB-INF/views/"+redirectUrl);
	    	  dispatcher.forward(request, response);
	    }

}

