package com.acd.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.acd.conn.DBUtils;
import com.acd.conn.MyUtils;
import com.acd.modal.UserAccount;


@WebServlet(urlPatterns = { "/deleteSugg" })
public class DeleteSuggetion extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3082955879508169058L;
	public DeleteSuggetion() {
		super();
	}
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		  Connection conn = MyUtils.getStoredConnection(request);
		  HttpSession session = request.getSession();
			 UserAccount userAccount = MyUtils.getLoginedUser(session);
			 Long suggId = (long) Integer.parseInt(request.getParameter("suggId"));
	        String errorString = null;
	        boolean list = false;
	        try {
				list = DBUtils.deleteSugg(conn,suggId);
			} catch (SQLException e) {
				errorString="Something went wrong";
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        // Store info in request attribute, before forward to views
	        request.setAttribute("errorString", errorString);
	    	response.sendRedirect(request.getContextPath() + "/adminSuggition?userType=ROLE_ADMIN");
	    }

}
