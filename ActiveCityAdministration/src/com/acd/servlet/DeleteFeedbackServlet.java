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
import com.acd.modal.Feedback;
import com.acd.modal.UserAccount;

@WebServlet(urlPatterns = { "/deleteFeedback" })
public class DeleteFeedbackServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3082955879508169058L;
	public DeleteFeedbackServlet() {
		super();
	}
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		  Connection conn = MyUtils.getStoredConnection(request);
		  HttpSession session = request.getSession();
			 UserAccount userAccount = MyUtils.getLoginedUser(session);
			 Long feedbackId = (long) Integer.parseInt(request.getParameter("feedbackId"));
	        String errorString = null;
	        boolean list = false;
	        try {
				list = DBUtils.deleteFeedback(conn,feedbackId);
			} catch (SQLException e) {
				errorString="Something went wrong";
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        // Store info in request attribute, before forward to views
	        request.setAttribute("errorString", errorString);
	    	response.sendRedirect(request.getContextPath() + "/adminFeedback?userType=ROLE_ADMIN");
	    }

}
