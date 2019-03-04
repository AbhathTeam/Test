<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			href="${pageContext.request.contextPath}/logout?userType=ADMIN">Logout</a>
     

	</div>
	<div class="container">
		<div class="fixed">
			<div>
				<ul type="bullets">
				 <input type="hidden" name="userType" value="ROLE_ADMIN" />
                    <li><a href="${pageContext.request.contextPath}/checkComplaints?userType=ROLE_ADMIN">COMPLAINTS</a></li>
                    <li><a href="${pageContext.request.contextPath}/adminSuggition?userType=ROLE_ADMIN">SUGGITIONS / PETIONS</a></li>
                    <li><a href="${pageContext.request.contextPath}/adminFeedback?userType=ROLE_ADMIN">FEEDBACK</a></li>
                   	<li><a
						href="${pageContext.request.contextPath}/officerDetails">OFFICERS</a></li>
                    <li><a href="${pageContext.request.contextPath}/ngoForm">NGO's</a></li>
                    <li><a href="${pageContext.request.contextPath}/adminActivity">ACTIVITY</a></li>
                    <li><a href="${pageContext.request.contextPath}/pollOperation">POLL OPERATION</a></li>
                </ul>
			</div>
		</div>
		<div class="flex-item">
		<h2>Welcome to Administrator Page</h2>
				</div>
	</div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>