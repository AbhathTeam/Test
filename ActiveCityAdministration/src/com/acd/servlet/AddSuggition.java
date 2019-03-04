package com.acd.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
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
import com.acd.modal.Department;
import com.acd.modal.Suggition;
import com.acd.modal.UserAccount;

@WebServlet(urlPatterns = { "/addSuggetion" })
public class AddSuggition extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6804897254792822006L;

	public AddSuggition() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		List<Department> departMentList = null;
		try {
			departMentList = DBUtils.findAllDepartments(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("departmentList", departMentList);
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/issueComplaints.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		  HttpSession session = request.getSession();
		 UserAccount userAccount = MyUtils.getLoginedUser(session);
		Long complaintById = 0L;
		Long departmentId = (long) Integer.parseInt(request.getParameter("department").toString());
		String complaintDescription = (String) request.getParameter("complaint_desc");
		String complaintTitle = (String) request.getParameter("complaint_title");
		Suggition suggition = new Suggition();
		suggition.setComplaintStatus("PENDING");
		suggition.setDepartmentId(departmentId);
		suggition.setComplaintDescription(complaintDescription);
		suggition.setComplaintTitle(complaintTitle);
		suggition.setComplaintDate(Calendar.getInstance().getTime());
		suggition.setComplaintBy(userAccount.getUserId());
		
		
		String regex = "\\w+";
		String resultString = null;

		if (resultString == null) {
			try {
				DBUtils.insertSuggition(conn, suggition);
				resultString = "Suggestion Raised Successfully";
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		List<Department> departMentList = null;
		try {
			departMentList = DBUtils.findAllDepartments(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("departmentList", departMentList);
		request.setAttribute("resultString", resultString);

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/suggetion.jsp");
		dispatcher.forward(request, response);

	}

}
