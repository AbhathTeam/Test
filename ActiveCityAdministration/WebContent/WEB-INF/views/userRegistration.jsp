<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
           <title>CitizenRegistrationPage</title>
    <style>
        table{
            margin-left:30%;
            margin-top:10px;
            border:1px solid rgb(189, 189, 240);
            background-color:lightblue ;
        }
        td{
            padding:10px;
        
        }
        
        
    </style>
   </head>
   <body>
    
      <jsp:include page="header.jsp"></jsp:include>
      <jsp:include page="menu.jsp"></jsp:include>
      <p style="color: red;">${errorString}</p>
       
      <form autocomplete="off" method="POST" action="${pageContext.request.contextPath}/createUser">
                <table >
                        <tr>
                              <th><h2>Citizen's Registration</h2></th>
                        </tr>
                      <!--   <tr>
                            <td>Citizen ID:</td>
                            <td><input type="text" name="cid" class="form-control"></td>
                        </tr> -->
                        <tr>
                                <td>Citizen FullName:</td>
                                <td><input type="text" name="fullName" class="form-control"></td>
                        </tr>
                        <tr>
                                <td>UserName:</td>
                                <td><input type="text" name="userName" class="form-control">
                                <input type="hidden" name="userType" value="ROLE_CITIZEN" class="form-control"></td>
                         </tr>
                         <tr>
                                <td>Password:</td>
                                <td><input type="password" name="pwd" class="form-control"></td>
                        </tr>
                        <tr>
                                <td>Confirm Password:</td>
                                <td><input type="password" name="cnfpwd" class="form-control"></td>
                         </tr>
                         <tr>
                                <td>Gender</td>
                                <td>
                                <input type="hidden" name="approvalStatus" value="1" class="form-control">
                                    <input type="radio" name="gender" class="form-control" value="M">Male
                                    <input type="radio" name="gender" class="form-control" value="F">Female
                                </td>
                        </tr>
                        <tr>
                                <td>Address</td>
                                <td><textarea name="address" class="form-control"></textarea></td>
                        </tr>
                        <tr>
                                <td>Email:</td>
                                <td><input type="email" name="email" class="form-control"></td>
                        </tr>
                        <tr>
                                <td>Mobile:</td>
                                <td><input type="text" name="mobile" class="form-control"></td>
                        </tr>
                        <tr>
                            <td></td><td><button type="reset">Clear</button>
                            <button type="submit">Register</button></td>
                              
                        </tr>
                    </table>
          
      </form>     
       
      <jsp:include page="footer.jsp"></jsp:include>
       
   </body>
</html>