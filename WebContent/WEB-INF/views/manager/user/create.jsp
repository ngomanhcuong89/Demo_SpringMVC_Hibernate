<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/checkUserIsActive.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New User</title>
</head>
<body>
	<h1>Create New User</h1>
	<form action="/Slide06lab1demo/user/add.htm" method="POST">
		<p>Username</p>
		<input type="text" name="username" placeholder="Username"/>
		<p>Password</p>
		<input type="text" name="password" placeholder="Password"/>
		<p>Fullname</p>
		<input type="text" name="fullname" placeholder="Fullname"/>
		<p>IsAdmin</p>
		Admin <input type="radio" name="isadmin" value="true"/>
		Staff <input type="radio" name="isadmin" value="false"/>
		<p>Staff</p>
		<select name="staffId">
			<c:forEach items="${staffs}" var="item">
				<option value="${item.id}">${item.name}</option>
			</c:forEach>
		</select>
		<br><br>
		<button>Create Now</button>
	</form>
	<hr>
	<p>Click <a href="/Slide06lab1demo/user/list.htm">here</a> Back List User</p>
</body>
</html>