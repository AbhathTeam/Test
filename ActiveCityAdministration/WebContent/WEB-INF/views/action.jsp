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
					<li><a href="${pageContext.request.contextPath}/issueComplaints">ISSUE COMPLAINTS</a></li>
					<li><a href="${pageContext.request.contextPath}/checkComplaints">CHECK COMPLAINT STATUS</a></li>
					<li><a href="${pageContext.request.contextPath}/suggetion">SUGGITIONS / PETIONS</a></li>
					<li><a href="${pageContext.request.contextPath}/feedback">SUMIT FEEDBACK & ALSO BROWSE </a></li>
					<li><a href="${pageContext.request.contextPath}/complaints">COMPLAINTS</a></li>
					<li><a class="active" href="${pageContext.request.contextPath}/actions">Activities</a></li>
				</ul>
			</div>
		</div>
		<div class="flex-item">
			 <table >
                        <tr>
                            <th>Complaint ID</th><th>Article Name</th><th>Article Description</th>                        </tr>
                        <tr>
                            <td>101</td><td>Indian Culture</td><td>We should always our Indian culture</td> 
                        </tr>
                        <tr>
                            <td>102</td><td>Blood donation</td><td>Blood donation is the greatest and best donation</td>
                          </tr>
                          
                    </table>
		</div>
	</div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>