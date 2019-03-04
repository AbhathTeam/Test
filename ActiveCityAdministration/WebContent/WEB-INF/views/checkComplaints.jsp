<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/style.css">

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div style="height: 55px; padding: 5px; width: 100%;">

		<a href="${pageContext.request.contextPath}/">Home</a> <a
			href="${pageContext.request.contextPath}/logout?userType=CITIZEN">Logout</a>


	</div>
	<div class="container">
		<div class="fixed">
			<div>
				<ul type="bullets">
					<li><a
						href="${pageContext.request.contextPath}/issueComplaints">ISSUE
							COMPLAINTS</a></li>
					<li><a class="active"
						href="${pageContext.request.contextPath}/checkComplaints">CHECK
							COMPLAINT STATUS</a></li>
					<li><a href="${pageContext.request.contextPath}/suggetion">SUGGITIONS
							/ PETIONS</a></li>
					<li><a href="${pageContext.request.contextPath}/feedback">SUMIT
							FEEDBACK & ALSO BROWSE </a></li>
					<li><a href="${pageContext.request.contextPath}/complaints">COMPLAINTS</a></li>
					<li><a href="${pageContext.request.contextPath}/actions">Activities</a></li>
				</ul>
			</div>
		</div>
		<div class="flex-item">
			<table border="1">
				<tr>
					<th>Complaint Title</th>
					<th>Complaint Description</th>
					<th>Department</th>
					<th>Complaint Date</th>
					<th>Status</th>
				</tr>
				<c:forEach items="${complaintList}" var="complaint">
					<tr>
						<td>${complaint.complaintTitle}</td>
						<td>${complaint.complaintDescription}</td>
						<td>${complaint.getDepartment().deptName}</td>
						<td>
						<fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${complaint.complaintDate}" />
						</td>
						<td>${complaint.getStatusTable().statusDescription}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>