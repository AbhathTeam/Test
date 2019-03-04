<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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
			<p style="color: green;">${resultString}</p>
		<form autocomplete="off" method="POST"
				action="${pageContext.request.contextPath}/addSuggetion">
				<table>
					<tr>
					<input type="hidden" name="userType" value="ROLE_CITIZEN" />
						<th><h2 style="text-align: center;">Write Suggestion Here</h2></th>
					</tr>
					<tr>
						<td>Region or Department:</td>
						<td><select name="department">
								<option>....Select Department....</option>
								<c:forEach items="${departmentList}" var="department">
								${department }
									<option value="${department.deptId}">${department.deptName}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>Suggestion  Title</td>
						<td><input name="complaint_title" cols="30" rows="5"></td>
					</tr>
					<tr>
						<td>Suggestion  Description</td>
						<td><textarea name="complaint_desc" cols="30" rows="5"></textarea></td>
					</tr>
					<tr>
						<td><button type="submit" id="">Submit</button></td>
					</tr>
				</table>

			</form>
		</div>
	</div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>