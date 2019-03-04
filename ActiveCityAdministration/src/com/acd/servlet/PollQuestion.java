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

@WebServlet(urlPatterns = { "/pollOperation"})
public class PollQuestion  extends HttpServlet{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 8837774453611720170L;

	@Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	 
		   Connection conn = MyUtils.getStoredConnection(request);
			 
	       // Forward to /WEB-INF/views/homeView.jsp
	       // (Users can not access directly into JSP pages placed in WEB-INF)
	       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pollQuestion.jsp");
	        
	       dispatcher.forward(request, response);
	        
	   }

}
