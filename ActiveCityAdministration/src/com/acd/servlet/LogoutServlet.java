package com.acd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.acd.conn.MyUtils;

@WebServlet(urlPatterns = { "/logout" })
public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1993815253014450232L;

	 public LogoutServlet() {
	        super();
	    }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userType = request.getParameter("userType");

		HttpSession session = request.getSession();
		session.invalidate();
		MyUtils.deleteUserCookie(response);
		String redirectPage = null;
		if("CITIZEN".equals(userType)) {
			redirectPage = "/WEB-INF/views/userLogin.jsp";
		}else if("NGO".equals(userType)) {
			redirectPage = "/WEB-INF/views/ngoLogin.jsp";
		}else {
			redirectPage = "/WEB-INF/views/adminLogin.jsp";
		}
		RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher(redirectPage);

		dispatcher.forward(request, response);
	}

}
