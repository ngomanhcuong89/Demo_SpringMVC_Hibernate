<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/checkUserIsActive.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<base href="${pageContext.servletContext.contextPath}/" />
</head>
<body>
	<c:if test="${not empty thongbao}">
		<p style="color:red">${thongbao} create account</p>
	</c:if>
	<h1>List Staff</h1>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Birthday</th>
			<th>Photo</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Salary</th>
			<th>Note</th>
			<th>Depart</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${stafflist}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.gender == true ? "Female" : "Male"}</td>
				<td>${item.birthday}</td>
				<td><img src="hinhanh/${item.photo}" style="width:150px; heigth:150px"/></td>
				<td>${item.email}</td>
				<td>${item.phone}</td>
				<td>${item.salary}</td>
				<td>${item.note}</td>
				<td>${item.departId}</td>
				<td>
					<a href="/Slide06lab1demo/staff/update/${item.id}.htm">Edit</a> || <a href="/Slide06lab1demo/staff/delete/${item.id}.htm">Delete</a>
				</td>			
			</tr>
		</c:forEach>
	</table>
	<hr>
	<p>Click <a href="/Slide06lab1demo/staff/add.htm">here</a> Create New User</p>
	<p>Click to <a href="/Slide06lab1demo/home/manager.htm">here</a> Back manager</p>	
</body>
</html>