package com.acd.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.acd.conn.DBUtils;
import com.acd.conn.MyUtils;
import com.acd.modal.UserAccount;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
    }
 
    // Show Login page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Forward to /WEB-INF/views/loginView.jsp
        // (Users can not access directly into JSP pages placed in WEB-INF)
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userLogin.jsp");
 
        dispatcher.forward(request, response);
 
    }
 
    // When the user enters userName & password, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");
        String rememberMeStr = request.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMeStr);
 
        UserAccount user = null;
        boolean hasError = false;
        String errorString = null;
 
        if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Required username and password!";
        } else {
            Connection conn = MyUtils.getStoredConnection(request);
            try {
                // Find the user in the DB.
                user = DBUtils.findUser(conn, userName, password);
 
                if (user == null) {
                    hasError = true;
                    errorString = "User Name or password invalid";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        // If error, forward to /WEB-INF/views/login.jsp
        if (hasError) {
            // Store information in request attribute, before forward.
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", null);
            redirectRequestedUrl(userType,request,response);
        }
        // If no error
        // Store user information in Session
        // And redirect to userInfo page.
        else {
            HttpSession session = request.getSession();
            MyUtils.storeLoginedUser(session, user);
 
            // If user checked "Remember me".
            if (remember) {
                MyUtils.storeUserCookie(response, user);
            }
            // Else delete cookie.
            else {
                MyUtils.deleteUserCookie(response);
            }
            Connection conn = MyUtils.getStoredConnection(request);
            String redirectSuccessUrl=null;
            String userTypeObj = null;
			try {
				userTypeObj = DBUtils.findUserRole(conn, user.getUserId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(userTypeObj == null) {
				 redirectRequestedUrl(userType,request,response);
			}
			 RequestDispatcher dispatcher =null;
        	if("ROLE_CITIZEN".equals(userTypeObj)) {
        		response.sendRedirect(request.getContextPath() + "/userInfo");
        		redirectSuccessUrl = "userInfo";
        	}else if("ROLE_OFFICER".equals(userTypeObj)) {
        		redirectSuccessUrl = "officersLogin.jsp";
        		 dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/"+redirectSuccessUrl);
        		 dispatcher.forward(request, response);
        	}else if("ROLE_NGO".equals(userTypeObj)) {
        		redirectSuccessUrl = "ngoLogin.jsp";
        		 dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/"+redirectSuccessUrl);
        		 dispatcher.forward(request, response);
        	}else {
        		redirectSuccessUrl = "adminHomePage.jsp";
        		 dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/"+redirectSuccessUrl);
        		 dispatcher.forward(request, response);
        	}
        }
    }
    private void redirectRequestedUrl(String userType,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	
    	String redirectUrl = "userLogin.jsp";
    	if("ROLE_CITIZEN".equals(userType)) {
    		redirectUrl = "userLogin.jsp";
    	}else if("ROLE_OFFICER".equals(userType)) {
    		 redirectUrl = "officersLogin.jsp";
    	}else if("ROLE_NGO".equals(userType)) {
    		 redirectUrl = "ngoLogin.jsp";
    	}else {
    		 redirectUrl = "adminLogin.jsp";
    	}
    	String errorString = "User Name or password invalid";
    	   request.setAttribute("errorString", errorString);
    	  RequestDispatcher dispatcher //
          = request.getServletContext().getRequestDispatcher("/WEB-INF/views/"+redirectUrl);
    	  dispatcher.forward(request, response);
    }
 
}