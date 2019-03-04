<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Login</title>
<link href="style/style.css" rel="stylesheet" type="text/css" />
<style>
table {
	margin-left: 40%;
	margin-top: 5%;
	border: 1px solid rgb(189, 189, 240);
	background-color: lightblue;
}

td, th {
	padding: 10px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>

	<p style="color: red;">${errorString}</p>



	<form autocomplete="off" method="POST"
		action="${pageContext.request.contextPath}/login">
		<table>
			<tr>
				<th><h2>UserLogin</h2></th>
			</tr>
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="userName" value="${user.userName}"
					class="form-control">
					 <input type="hidden" name="userType" value="ROLE_CITIZEN" class="form-control">
                    
					</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"
					value="${user.password}" class="form-control"></td>
			</tr>
			<tr>
                 <td> <a href="${pageContext.request.contextPath}/createUser">New User</a></td>
				<td><button type="submit" id="">Login</button></td>
			</tr>
		</table>

	</form>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>