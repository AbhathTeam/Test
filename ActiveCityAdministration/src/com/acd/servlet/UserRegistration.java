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

import com.acd.conn.DBUtils;
import com.acd.conn.MyUtils;
import com.acd.modal.UserAccount;

@WebServlet(urlPatterns = { "/createUser" })
public class UserRegistration extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5752795033668066892L;
	
	 public UserRegistration() {
	        super();
	    }
	 
	    // Show product creation page.
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/userRegistration.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Connection conn = MyUtils.getStoredConnection(request);
	 
	        String cid = (String) request.getParameter("cid");
	        String fullName = (String) request.getParameter("fullName");
	        String userName = (String) request.getParameter("userName");
	        String password = (String) request.getParameter("pwd");
	        String gender = (String) request.getParameter("gender");
	        String email = (String) request.getParameter("email");
	        String mobile = (String) request.getParameter("mobile");
	        String address = (String) request.getParameter("address"); 
	        String userType= (String) request.getParameter("userType");
	        Long isApproved = (long) Integer.parseInt(request.getParameter("approvalStatus"));
			UserAccount user = new UserAccount();
			user.setIsApproved(isApproved);
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			user.setFullName(fullName);
			user.setAddress(address);
			user.setEmail(email);
			user.setMobile(mobile);
			user.setDepartmentId(null);
	        String regex = "\\w+";
	        String errorString = null;
	        
	        if (userName == null || password == null) {
	            errorString = "Please Enter User Name or password!";
	        }
	        if (errorString == null) {
	            try {
	            	UserAccount existUserAccount = DBUtils.findUser(conn, userName);
	            	if(existUserAccount == null) {
	            		 DBUtils.insertUserAccount(conn, user,userType);
	            		 errorString = "Successfully Registred";
	            	}else {
	            		errorString = "User Already exists.";
	            	}
	            } catch (SQLException e) {
	                e.printStackTrace();
	                
	            }
	        }
	     
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("userAccount", user);
	 
	        // If error, forward to Edit page.
	        if (errorString != null) {
	        	
	        	redirectRequestedUrl(userType, request, response,errorString);
	            
	        }
	        // If everything nice.
	        // Redirect to the product listing page.
	        else {
	        	redirectRequestedUrl(userType, request, response,errorString);
	        	RequestDispatcher dispatcher = request.getServletContext()
	                    .getRequestDispatcher("/WEB-INF/views/userRegistration.jsp");
	            dispatcher.forward(request, response);
	        }
	    }
	    private void redirectRequestedUrl(String userType,HttpServletRequest request,HttpServletResponse response,String errorString) throws ServletException, IOException {
	    	
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
	    	   request.setAttribute("errorString", errorString);
	    	  RequestDispatcher dispatcher //
	          = request.getServletContext().getRequestDispatcher("/WEB-INF/views/"+redirectUrl);
	    	  dispatcher.forward(request, response);
	    }

}
