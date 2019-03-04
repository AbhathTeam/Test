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

import com.acd.conn.DBUtils;
import com.acd.conn.MyUtils;
import com.acd.modal.UserAccount;

@WebServlet(urlPatterns = { "/officerDetails"})
public class OfficerServlet extends HttpServlet {
	   private static final long serialVersionUID = 1L;
	   
	   public OfficerServlet() {
	       super();
	   }
	 
	   @Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	 
		   Connection conn = MyUtils.getStoredConnection(request);
			 
			 List<UserAccount> list = null;
		        try {
		            list = DBUtils.findUserList(conn,"ROLE_OFFICER");
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        request.setAttribute("usersList", list);
	       // Forward to /WEB-INF/views/homeView.jsp
	       // (Users can not access directly into JSP pages placed in WEB-INF)
	       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/officersDetails.jsp");
	        
	       dispatcher.forward(request, response);
	        
	   }
}