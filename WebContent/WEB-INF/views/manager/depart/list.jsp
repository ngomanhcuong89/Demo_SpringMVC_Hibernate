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
	<h1>List Depart</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${listdepart}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>
					<a href="/Slide06lab1demo/depart/update/${item.id}.htm">Edit</a> ||
					<a href="/Slide06lab1demo/depart/delete/${item.id}.htm">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<p>Click to <a href="/Slide06lab1demo/depart/save.htm">here</a> Create new Depart</p>
	<p>Click to <a href="/Slide06lab1demo/home/manager.htm">here</a> Back manager</p>
</body>
</html>