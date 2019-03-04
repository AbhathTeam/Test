package com.acd.conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.acd.modal.Complaint;
import com.acd.modal.Department;
import com.acd.modal.Feedback;
import com.acd.modal.Product;
import com.acd.modal.StatusTable;
import com.acd.modal.Suggition;
import com.acd.modal.UserAccount;

public class DBUtils {
	
	public static List<UserAccount> findUserList(Connection conn, String userType) throws SQLException {

		List<UserAccount>  userList = new ArrayList<UserAccount>();
		String sql = "Select a.USER_ID, a.USER_FULL_NAME, a.USER_NAME,a.GENDER,a.ADDRESS,a.EMAIL_ID,a.MOBILE_NO,a.PASSWORD,a.IS_APPROVED,a.DEP_ID "
				+ "from User_Account a INNER JOIN USER_ROLE_M b  ON a.USER_ID = b.USER_ID where b.ROLE_ID in(select ROLE_ID from roles where ROLE_NAME=?)";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userType);
		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String gender = rs.getString("GENDER");
			long userId = rs.getLong("USER_ID");
			String appUserName = rs.getString("USER_NAME");
			String fullName = rs.getString("USER_FULL_NAME");
			String mobile = rs.getString("MOBILE_NO");
			String address = rs.getString("ADDRESS");
			String email = rs.getString("EMAIL_ID");
			String userPassword = rs.getString("PASSWORD");
			Long approved = rs.getLong("IS_APPROVED");
			Long deptId = rs.getLong("USER_ID");
			UserAccount user = new UserAccount();
			user.setUserId(userId);
			user.setUserName(appUserName);
			user.setPassword(userPassword);
			user.setGender(gender);
			user.setIsApproved(approved);
			user.setFullName(fullName);
			user.setAddress(address);
			user.setEmail(email);
			user.setMobile(mobile);
			user.setDepartmentId(deptId);
			if(approved == 1) {
				user.setApprovalStatus("Approved");
			}else {
				user.setApprovalStatus("DisApproved");
			}
			userList.add(user);
			return userList;
		}
		return null;
	}

	public static UserAccount findUser(Connection conn, //
			String userName, String password) throws SQLException {

		String sql = "Select a.USER_ID, a.USER_FULL_NAME, a.USER_NAME,a.GENDER,a.ADDRESS,a.EMAIL_ID,a.MOBILE_NO,a.PASSWORD,a.IS_APPROVED,a.DEP_ID from User_Account a " //
				+ " where a.User_Name = ? and a.password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String gender = rs.getString("GENDER");
			long userId = rs.getLong("USER_ID");
			String appUserName = rs.getString("USER_NAME");
			String fullName = rs.getString("USER_FULL_NAME");
			String mobile = rs.getString("MOBILE_NO");
			String address = rs.getString("ADDRESS");
			String email = rs.getString("EMAIL_ID");
			String userPassword = rs.getString("PASSWORD");
			Long approved = rs.getLong("IS_APPROVED");
			Long deptId = rs.getLong("USER_ID");
			UserAccount user = new UserAccount();
			user.setUserId(userId);
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			user.setIsApproved(approved);
			user.setFullName(fullName);
			user.setAddress(address);
			user.setEmail(email);
			user.setMobile(mobile);
			user.setDepartmentId(deptId);
			return user;
		}
		return null;
	}
	public static String findUserRole(Connection conn,Long appUserId) throws SQLException {
		
		String sql = "select (select ROLE_NAME from ROLES where ROLE_ID=b.ROLE_ID)ROLE_NAME,(select ROLE_DESC from ROLES where ROLE_ID=b.ROLE_ID)ROLE_DESC from USER_ACCOUNT a  INNER JOIN USER_ROLE_M b  ON a.USER_ID = b.USER_ID where a.USER_ID=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, appUserId);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			return rs.getString("ROLE_NAME");
		}
		return null;
	}

	public static List<Department> findAllDepartments(Connection conn) throws SQLException {
		List<Department> deparmentList = new ArrayList<Department>();

		String sql = "select DEP_ID,DEP_NAME from DEPT_TABLE";

		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			Department department = new Department();
			department.setDeptId(rs.getLong("DEP_ID"));
			department.setDeptName(rs.getString("DEP_NAME"));
			deparmentList.add(department);
		}
		return deparmentList;
	}
	public static Department finDepartmentByDeptId(Connection conn,Long departmentId) throws SQLException {

		String sql = "select DEP_ID,DEP_NAME from DEPT_TABLE where DEP_ID=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, departmentId);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			Department department = new Department();
			department.setDeptId(rs.getLong("DEP_ID"));
			department.setDeptName(rs.getString("DEP_NAME"));
			return department;
		}
		return null;
	}


	public static UserAccount findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a "//
				+ " where a.User_Name = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}

	public static List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select a.Code, a.Name, a.Price from Product a ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String code = rs.getString("Code");
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			Product product = new Product();
			product.setCode(code);
			product.setName(name);
			product.setPrice(price);
			list.add(product);
		}
		return list;
	}
	public static List<Complaint> queryComplaints(Connection conn,Long appUserId,String userType) throws SQLException {
		String sql = "";
		if("ROLE_ADMIN".equals(userType)) {
			sql = "Select a.COMPLAINT_ID,a.COMPLAINT_DESC,a.COMPLAINT_DATE,COMPLAINT_STATUS,a.ADDED_BY_ID,a.MODIFIED_BY_ID,a.DEP_ID,a.COMPLAINT_TITLE from COMPLAINTS a";
		}else {
			sql = "Select a.COMPLAINT_ID,a.COMPLAINT_DESC,a.COMPLAINT_DATE,COMPLAINT_STATUS,a.ADDED_BY_ID,a.MODIFIED_BY_ID,a.DEP_ID,a.COMPLAINT_TITLE from COMPLAINTS a where a.ADDED_BY_ID=?";

		}
		PreparedStatement pstm = conn.prepareStatement(sql);
		if(!"ROLE_ADMIN".equals(userType)) {
			 pstm.setLong(1, appUserId);
		}
		
		ResultSet rs = pstm.executeQuery();
		List<Complaint> complaintList = new ArrayList<Complaint>();
		while (rs.next()) {
			Long complaintId = rs.getLong("COMPLAINT_ID");
			String complaintDesc = rs.getString("COMPLAINT_DESC");
			Date compaintDate = rs.getDate("COMPLAINT_DATE");
			String complaintStatus = rs.getString("COMPLAINT_STATUS");
			Long addedById = rs.getLong("ADDED_BY_ID");
			Long modifiedId = rs.getLong("MODIFIED_BY_ID");
			Long deptId = rs.getLong("DEP_ID");
			String complaintTitle = rs.getString("COMPLAINT_TITLE");
			Complaint complaint = new Complaint();
			Department department = finDepartmentByDeptId(conn,deptId);
			complaint.setDepartment(department);
			complaint.setComplaintBy(complaintId);
			complaint.setComplaintDate(compaintDate);
			complaint.setComplaintDescription(complaintDesc);
			complaint.setComplaintStatus(complaintStatus);
			complaint.setComplaintTitle(complaintTitle);
			complaint.setComplaintBy(addedById);
			complaint.setDepartmentId(deptId);
			complaint.setModifiedById(modifiedId);
			StatusTable statusTable = findStatus(conn, complaintStatus);
			complaint.setStatusTable(statusTable);
			complaintList.add(complaint);
		}
		return complaintList;
	}

	public static Product findProduct(Connection conn, String code) throws SQLException {
		String sql = "Select a.Code, a.Name, a.Price from Product a where a.Code=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, code);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			Product product = new Product(code, name, price);
			return product;
		}
		return null;
	}

	public static void updateProduct(Connection conn, Product product) throws SQLException {
		String sql = "Update Product set Name =?, Price=? where Code=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getName());
		pstm.setFloat(2, product.getPrice());
		pstm.setString(3, product.getCode());
		pstm.executeUpdate();
	}

	public static void insertProduct(Connection conn, Product product) throws SQLException {
		String sql = "Insert into Product(Code, Name,Price) values (?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getCode());
		pstm.setString(2, product.getName());
		pstm.setFloat(3, product.getPrice());

		pstm.executeUpdate();
	}

	public static void deleteProduct(Connection conn, String code) throws SQLException {
		String sql = "Delete From Product where Code= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, code);

		pstm.executeUpdate();
	}

	public static void insertUserAccount(Connection conn, UserAccount userAccount, String userType)
			throws SQLException {

		long appUserId = 0;
		String seqQuery = "select USER_ACCOUNT_SEQ.nextval from dual";

		PreparedStatement usPs = conn.prepareStatement(seqQuery);

		ResultSet rs1 = usPs.executeQuery();
		while (rs1.next()) {
			appUserId = rs1.getLong("NEXTVAL");
		}

		String sql = "Insert into USER_ACCOUNT(USER_ID, IS_APPROVED,USER_FULL_NAME,USER_NAME,GENDER,ADDRESS,EMAIL_ID,MOBILE_NO,PASSWORD,DEP_ID) values (?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, appUserId);
		pstm.setLong(2, userAccount.getIsApproved());
		pstm.setString(3, userAccount.getFullName());
		pstm.setString(4, userAccount.getUserName());
		pstm.setString(5, userAccount.getGender());
		pstm.setString(6, userAccount.getAddress());
		pstm.setString(7, userAccount.getEmail());
		pstm.setString(8, userAccount.getMobile());
		pstm.setString(9, userAccount.getPassword());
		if(userAccount.getDepartmentId() ==  null) {
			pstm.setNull(10, java.sql.Types.INTEGER);
		}else {
			pstm.setLong(10, userAccount.getDepartmentId());
		}
		pstm.executeUpdate();
		String userRoleSql = "Insert into USER_ROLE_M(ROLE_ID,USER_ID) values ((select ROLE_ID from roles where ROLE_NAME='"
				+ userType + "')," + appUserId + ")";
		PreparedStatement pstm2 = conn.prepareStatement(userRoleSql);
		pstm2.executeUpdate();
	}

	public static void insertComplaint(Connection conn, Complaint complaint) throws SQLException {
		long complaintId = 0;
		String seqQuery = "select COMPLAINTS_SEQ.nextval from dual";

		PreparedStatement usPs = conn.prepareStatement(seqQuery);

		ResultSet rs1 = usPs.executeQuery();
		while (rs1.next()) {
			complaintId = rs1.getLong("NEXTVAL");
		}

		String sql = "Insert into COMPLAINTS(COMPLAINT_ID, COMPLAINT_DESC,DEP_ID,COMPLAINT_DATE,COMPLAINT_STATUS,ADDED_BY_ID,COMPLAINT_TITLE) values (?,?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, complaintId);
		pstm.setString(2, complaint.getComplaintDescription());
		pstm.setLong(3, complaint.getDepartmentId());
		pstm.setDate(4, new java.sql.Date(complaint.getComplaintDate().getTime()));
		pstm.setString(5, complaint.getComplaintStatus());
		pstm.setLong(6, complaint.getComplaintBy());
		pstm.setString(7, complaint.getComplaintTitle());
		pstm.executeUpdate();
	}
	public static void insertSuggition(Connection conn, Suggition suggition) throws SQLException {
		long complaintId = 0;
		String seqQuery = "select SUGG_PET_SEQ.nextval from dual";

		PreparedStatement usPs = conn.prepareStatement(seqQuery);

		ResultSet rs1 = usPs.executeQuery();
		while (rs1.next()) {
			complaintId = rs1.getLong("NEXTVAL");
		}

		String sql = "Insert into SUGG_PET(SUGG_PET_ID, SUGG_DESC,DEP_ID,SUGG_DATE,SUGG_STATUS,ADDED_BY_ID,SUGG_TITLE) values (?,?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, complaintId);
		pstm.setString(2, suggition.getComplaintDescription());
		pstm.setLong(3, suggition.getDepartmentId());
		pstm.setDate(4, new java.sql.Date(suggition.getComplaintDate().getTime()));
		pstm.setString(5, suggition.getComplaintStatus());
		pstm.setLong(6, suggition.getComplaintBy());
		pstm.setString(7, suggition.getComplaintTitle());
		pstm.executeUpdate();
	}
	public static void insertFeedback(Connection conn, Feedback feedback) throws SQLException {
		long complaintId = 0;
		String seqQuery = "select FEEDBACK_SEQ.nextval from dual";

		PreparedStatement usPs = conn.prepareStatement(seqQuery);

		ResultSet rs1 = usPs.executeQuery();
		while (rs1.next()) {
			complaintId = rs1.getLong("NEXTVAL");
		}

		String sql = "Insert into FEEDBACK(FEEFBACK_ID, FEED_DESC,DEP_ID,FEED_DATE,FEED_STATUS,ADDED_BY_ID,FEED_TITLE) values (?,?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, complaintId);
		pstm.setString(2, feedback.getComplaintDescription());
		pstm.setLong(3, feedback.getDepartmentId());
		pstm.setDate(4, new java.sql.Date(feedback.getComplaintDate().getTime()));
		pstm.setString(5, feedback.getComplaintStatus());
		pstm.setLong(6, feedback.getComplaintBy());
		pstm.setString(7, feedback.getComplaintTitle());
		pstm.executeUpdate();
		
	}
	public static StatusTable findStatus(Connection conn,String statusCode) throws SQLException {

		List<StatusTable> list = null;
		String sql = "select STATUS_ID,STATUS_DSCP,STATUS_CODE from APP_STATUS_TABLE where STATUS_CODE=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, statusCode);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			StatusTable statusTable = new StatusTable();
			statusTable.setStatusId(rs.getLong("STATUS_ID"));
			statusTable.setStatusCode(rs.getString("STATUS_CODE"));
			statusTable.setStatusDescription(rs.getString("STATUS_DSCP"));
			return statusTable;
		}
		return null;
	}
	public static List<StatusTable> findStatusList(Connection conn) throws SQLException {

		List<StatusTable> list = null;
		String sql = "select STATUS_ID,STATUS_DSCP,STATUS_CODE from APP_STATUS_TABLE";

		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			StatusTable statusTable = new StatusTable();
			statusTable.setStatusId(rs.getLong("STATUS_ID"));
			statusTable.setStatusCode(rs.getString("STATUS_DSCP"));
			statusTable.setStatusDescription(rs.getString("STATUS_CODE"));
			list.add(statusTable);
			return list;
		}
		return null;
	}
	public static List<Suggition> querySuggetionLit(Connection conn, long userId, String userType) throws SQLException {

		String sql = "";
		if("ROLE_ADMIN".equals(userType)) {
			sql = "Select a.SUGG_PET_ID,a.SUGG_DESC,a.SUGG_DATE,SUGG_STATUS,a.ADDED_BY_ID,a.MODIFIED_BY_ID,a.DEP_ID,a.SUGG_TITLE from SUGG_PET a";
		}else {
			sql = "Select a.SUGG_PET_ID,a.SUGG_DESC,a.SUGG_DATE,SUGG_STATUS,a.ADDED_BY_ID,a.MODIFIED_BY_ID,a.DEP_ID,a.SUGG_TITLE from SUGG_PET a where a.ADDED_BY_ID=?";

		}
		PreparedStatement pstm = conn.prepareStatement(sql);
		if(!"ROLE_ADMIN".equals(userType)) {
			 pstm.setLong(1, userId);
		}
		
		ResultSet rs = pstm.executeQuery();
		List<Suggition> suggList = new ArrayList<Suggition>();
		while (rs.next()) {
			Long complaintId = rs.getLong("SUGG_PET_ID");
			String complaintDesc = rs.getString("SUGG_DESC");
			Date compaintDate = rs.getDate("SUGG_DATE");
			String complaintStatus = rs.getString("SUGG_STATUS");
			Long addedById = rs.getLong("ADDED_BY_ID");
			Long modifiedId = rs.getLong("MODIFIED_BY_ID");
			Long deptId = rs.getLong("DEP_ID");
			String complaintTitle = rs.getString("SUGG_TITLE");
			Suggition suggeion = new Suggition();
			Department department = finDepartmentByDeptId(conn,deptId);
			suggeion.setComplaintId(complaintId);
			suggeion.setDepartment(department);
			suggeion.setComplaintBy(addedById);
			suggeion.setComplaintDate(compaintDate);
			suggeion.setComplaintDescription(complaintDesc);
			suggeion.setComplaintStatus(complaintStatus);
			suggeion.setComplaintTitle(complaintTitle);
			suggeion.setComplaintBy(addedById);
			suggeion.setDepartmentId(deptId);
			suggeion.setModifiedById(modifiedId);
			StatusTable statusTable = findStatus(conn, complaintStatus);
			suggeion.setStatusTable(statusTable);
			suggList.add(suggeion);
		}
		return suggList;
	
	}
	public static List<Feedback> queryFeedbackLit(Connection conn, long userId, String userType) throws SQLException {
		String sql = "";
		if("ROLE_ADMIN".equals(userType)) {
			sql = "Select a.FEEFBACK_ID,a.FEED_DESC,a.FEED_DATE,FEED_STATUS,a.ADDED_BY_ID,a.MODIFIED_BY_ID,a.DEP_ID,a.FEED_TITLE from FEEDBACK a";
		}else {
			sql = "Select a.FEEFBACK_ID,a.FEED_DESC,a.FEED_DATE,FEED_STATUS,a.ADDED_BY_ID,a.MODIFIED_BY_ID,a.DEP_ID,a.FEED_TITLE from FEEDBACK a where a.ADDED_BY_ID=?";

		}
		PreparedStatement pstm = conn.prepareStatement(sql);
		if(!"ROLE_ADMIN".equals(userType)) {
			 pstm.setLong(1, userId);
		}
		
		ResultSet rs = pstm.executeQuery();
		List<Feedback> suggList = new ArrayList<Feedback>();
		while (rs.next()) {
			Long complaintId = rs.getLong("FEEFBACK_ID");
			String complaintDesc = rs.getString("FEED_DESC");
			Date compaintDate = rs.getDate("FEED_DATE");
			String complaintStatus = rs.getString("FEED_STATUS");
			Long addedById = rs.getLong("ADDED_BY_ID");
			Long modifiedId = rs.getLong("MODIFIED_BY_ID");
			Long deptId = rs.getLong("DEP_ID");
			String complaintTitle = rs.getString("FEED_TITLE");
			Feedback suggeion = new Feedback();
			Department department = finDepartmentByDeptId(conn,deptId);
			suggeion.setDepartment(department);
			suggeion.setComplaintId(complaintId);
			suggeion.setComplaintBy(addedById);
			suggeion.setComplaintDate(compaintDate);
			suggeion.setComplaintDescription(complaintDesc);
			suggeion.setComplaintStatus(complaintStatus);
			suggeion.setComplaintTitle(complaintTitle);
			suggeion.setComplaintBy(addedById);
			suggeion.setDepartmentId(deptId);
			suggeion.setModifiedById(modifiedId);
			StatusTable statusTable = findStatus(conn, complaintStatus);
			suggeion.setStatusTable(statusTable);
			suggList.add(suggeion);
		}
		return suggList;
	}
	public static boolean deleteFeedback(Connection conn, Long feedbackId) throws SQLException {
		String sql = "delete from FEEDBACK where FEEFBACK_ID=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, feedbackId);
		pstm.executeUpdate();
		return true;
	}
	public static boolean deleteSugg(Connection conn, Long suggId) throws SQLException {
		String sql = "delete from SUGG_PET where SUGG_PET_ID=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, suggId);
		pstm.executeUpdate();
		return true;
	}

}
