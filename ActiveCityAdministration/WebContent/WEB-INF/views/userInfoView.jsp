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
			href="${pageContext.request.contextPath}/logout?userType=CITIZEN">Logout</a>


	</div>
	<div class="container">
		<div class="fixed">
			<div>
				<ul type="bullets">
					<li><a href="${pageContext.request.contextPath}/issueComplaints?userType=ROLE_CITIZEN">ISSUE COMPLAINTS</a></li>
					<li><a href="${pageContext.request.contextPath}/checkComplaints?userType=ROLE_CITIZEN">CHECK COMPLAINT STATUS</a></li>
					<li><a href="${pageContext.request.contextPath}/suggetion?userType=ROLE_CITIZEN">SUGGITIONS / PETIONS</a></li>
					<li><a href="${pageContext.request.contextPath}/feedback?userType=ROLE_CITIZEN">SUMIT FEEDBACK & ALSO BROWSE </a></li>
					<li><a href="${pageContext.request.contextPath}/complaints?userType=ROLE_CITIZEN">COMPLAINTS</a></li>
					<li><a href="${pageContext.request.contextPath}/actions?userType=ROLE_CITIZEN">ACTIONS</a></li>
				</ul>
			</div>
		</div>
		<div class="flex-item">
			<div>
				<p style="color: #FF33CC">
					<b>WELCOME CITIZEN....</b>
				</p>
				<p>
					&nbsp;&nbsp; <span style="color: #3333CC">A VERY BIG THANKS
						FOR BEING WITH ME.....&nbsp; &nbsp;&nbsp;</span>
				</p>
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp; <span style="color: #FF0000">&nbsp;&nbsp;&nbsp;
						**&nbsp; </span>&nbsp; WE WILL BE HERE FOR DEVELOPING OUR CITY.
				</p>
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span
						style="color: #FF0000">**&nbsp; </span>&nbsp; MAKE THE CITIES AS
					COPLAINTLESS .&nbsp;
				</p>
			</div>
		</div>
	</div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>