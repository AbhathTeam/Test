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
import com.acd.modal.Complaint;
import com.acd.modal.Suggition;
import com.acd.modal.UserAccount;

@WebServlet(urlPatterns = { "/adminSuggition" })
public class SuggestionLits extends HttpServlet{

		/**
		 * 
		 */
		private static final long serialVersionUID = 6318699493277483516L;
		public SuggestionLits() {
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
		        List<Suggition> list = null;
		        try {
		            list = DBUtils.querySuggetionLit(conn,userAccount.getUserId(),userType);
		        } catch (SQLException e) {
		            e.printStackTrace();
		            errorString = e.getMessage();
		        }
		        // Store info in request attribute, before forward to views
		        request.setAttribute("errorString", errorString);
		        request.setAttribute("suggitionList", list);
		        RequestDispatcher dispatcher = request.getServletContext()
		                .getRequestDispatcher("/WEB-INF/views/suggeionList.jsp");
		        dispatcher.forward(request, response);
		    }

	}
