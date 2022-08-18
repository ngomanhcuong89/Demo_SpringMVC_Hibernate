<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ include file="/WEB-INF/views/home/checkUserIsActive.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty thongbao}">
		<p style="color:red">${thongbao}</p>
	</c:if>
	<h1>List User</h1>
	<table border="1">
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Fullname</th>
			<th>Admin</th>
			<th>StaffId</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${listuser}" var="item">
			<tr>
				<td>${item.username}</td>
				<td>${item.password}</td>
				<td>${item.fullname}</td>
				<td>${item.isadmin}</td>
				<td>${item.staffId}</td>
				<td>
					<a href="/Slide06lab1demo/user/update/${item.username}.htm">Update</a> || <a href="/Slide06lab1demo/user/delete/${item.username}.htm">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<p>Click <a href="/Slide06lab1demo/user/add.htm">here</a> Create New User</p>
	<p>Click to <a href="/Slide06lab1demo/home/manager.htm">here</a> Back manager</p>
</body>
</html>