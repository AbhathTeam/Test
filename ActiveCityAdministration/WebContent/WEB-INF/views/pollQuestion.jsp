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
		  <form autocomplete="off">
                <table >
                        <tr>
                              <th><h2>Poll pollQuestionDetails</h2></th>
                        </tr>
                        <tr>
                            <td>Poll ID:</td>
                            <td><input type="text" name="pollid" class="form-control"></td>
                        </tr>
                        <tr>
                                <td>PollQuestion:</td>
                                <td><input type="text" name="pollquestion" class="form-control"></td>
                        </tr>
                        <tr>
                                <td>UserName:</td>
                                <td><input type="text" name="userName" class="form-control"></td>
                         </tr>
                         <tr>
                                <td>First Answere:</td>
                                <td><input type="text" name="ans1" class="form-control"></td>
                        </tr>
                        <tr>
                                <td>Second Answere:</td>
                                <td><input type="password" name="ans2" class="form-control"></td>
                         </tr>
                        <tr>
                                <td>Third Answere:</td>
                                <td><input type="text" name="ans3" class="form-control"></td>
                        </tr>
                        
                        <tr>
                            <td><a href="#">see poll openion details</a></td>
                            <td><button type="submit">Insert</button></td>
                              
                        </tr>
                    </table>
          
      </form>     
				</div>
	</div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>