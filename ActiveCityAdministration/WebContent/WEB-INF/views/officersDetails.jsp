<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/style.css">
<style>
.item-fixed{
    width: 500px;
}
.item-flex-item{
    flex-grow: 2;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div style="height: 55px; padding: 5px; width: 100%;">

		<a href="${pageContext.request.contextPath}/">Home</a> <a
			href="${pageContext.request.contextPath}/logout?userType=ADMIN">Logout</a>


	</div>
	<div class="container">
		<div class="fixed">
			<div>
				<ul type="bullets">
					<input type="hidden" name="userType" value="ROLE_ADMIN" />
					<li><a
						href="${pageContext.request.contextPath}/checkComplaints?userType=ROLE_ADMIN">COMPLAINTS</a></li>
					<li><a
						href="${pageContext.request.contextPath}/adminSuggition?userType=ROLE_ADMIN">SUGGITIONS
							/ PETIONS</a></li>
					<li><a
						href="${pageContext.request.contextPath}/adminFeedback?userType=ROLE_ADMIN">FEEDBACK</a></li>
					<li><a
						href="${pageContext.request.contextPath}/officerDetails">OFFICERS</a></li>
					<li><a href="${pageContext.request.contextPath}/ngoDetails">NGO's</a></li>
					<li><a href="${pageContext.request.contextPath}/adminActivity">ACTIVITY</a></li>
					<li><a href="${pageContext.request.contextPath}/pollOperation">POLL
							OPERATION</a></li>
				</ul>
			</div>
		</div>
		<div class="flex-item">
			<div class="container">
				<div class="item-fixed">
					<form autocomplete="off" method="POST"
						action="${pageContext.request.contextPath}/createUser">
						<table>
							<tr>
								<th><h1>Officers Details</h1></th>
							</tr>
							<tr>
								<td>Full Name:</td>
								<td><input type="text" name="fullName" class="form-control"></td>
							</tr>
							<tr>
								<td>UserName:</td>
								<td><input type="text" name="userName" class="form-control">
									<input type="hidden" name="userType" value="ROLE_OFFICER"
									class="form-control"></td>
								</td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type="password" name="pwd" class="form-control"></td>
							</tr>
							<tr>
								<td>Confirm Password:</td>
								<td><input type="password" name="cnfpwd"
									class="form-control"></td>
							</tr>
							<tr>
								<td>Gender</td>
								<td><input type="radio" name="gender" value="M"
									class="form-control">Male <input type="radio"
									name="gender" value="N" class="form-control">Female</td>
							</tr>
							<tr>
								<td>Address</td>
								<td><textarea name="address" class="form-control"></textarea></td>
							</tr>
							<tr>
								<td>Email:</td>
								<td><input type="text" name="email" class="form-control"></td>
							</tr>
							<tr>
								<td>Mobile:</td>
								<td><input type="text" name="mobile" class="form-control"></td>
							</tr>
							<tr>
								<td>Approval</td>
								<td><select name="approvalStatus">
										<option>...ApprovalStatus...</option>
										<option value="1">Approved</option>
										<option value="2">DisApproved</option>
								</select></td>
							</tr>
							<tr>
								<td></td>
								<td><button type="reset">Clear</button>
									<button type="submit">Register</button></td>

							</tr>
						</table>

					</form>
				</div>
			</div>
			<div class="item-flex-item">
			 <table border="1">
				<tr>
				<th>Officer User Full Name</th>
					<th>NGO User Name</th>
					<th>Mobile No</th>
					<th>Email</th>
					<th>Address</th>
				</tr>
				<c:forEach items="${usersList}" var="user">
					<tr>
						<td>${user.fullName}</td>
						<td>${user.userName}</td>
						<td>${user.mobile}</td>
						<td>${user.email}</td>
						<td>${user.address}</td>
					</tr>
				</c:forEach>
			</table>
			</div>
		</div>
	</div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>