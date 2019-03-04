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

@WebServlet(urlPatterns = { "/ngoForm" })
public class NgoDetail extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3613059539858267085L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Forward to /WEB-INF/views/loginView.jsp
        // (Users can not access directly into JSP pages placed in WEB-INF)
		 Connection conn = MyUtils.getStoredConnection(request);
		 
		 List<UserAccount> list = null;
	        try {
	            list = DBUtils.findUserList(conn,"ROLE_NGO");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        request.setAttribute("usersList", list);
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ngoForm.jsp");
 
        dispatcher.forward(request, response);
 
    }


}
