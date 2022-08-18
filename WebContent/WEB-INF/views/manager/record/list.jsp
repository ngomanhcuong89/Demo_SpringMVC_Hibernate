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
	<h1>List Record</h1>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Type</th>
			<th>Reason</th>
			<th>Date</th>
			<th>Staff</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${listrecord}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.type }</td>
				<td>${item.reason}</td>
				<td>${item.date}</td>
				<td>${item.staffId}</td>
				<td>
					<a href="/Slide06lab1demo/record/update/${item.id}.htm">Edit</a> || 
					<a href="/Slide06lab1demo/record/delete/${item.id}.htm">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<p>Click <a href="/Slide06lab1demo/record/save.htm">here</a> Create New Record</p>
	<p>Click <a href="/Slide06lab1demo/home/manager.htm">here</a> Back manager</p>
	
</body>
</html>