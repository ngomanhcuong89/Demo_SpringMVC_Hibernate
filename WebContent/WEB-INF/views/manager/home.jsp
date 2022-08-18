<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/home/checkUserIsActive.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	.menu
	{
		display: inline-block;
		border:1px solid;
		background-color:yellow;
	}
	.menu li
	{
		display: inline-block;
		margin-right: 25px;
		font-weight: bold;
	}
	.menu a
	{
		text-decoration: none;
	}
</style>
</head>
<body>
	<h1>Home Page Manager</h1>
	<h3 style="color:red">Hello ${sessionScope.user.username} || <a href="/Slide06lab1demo/home/logout.htm" style="color:black">Log Out</a></h3>
	<ul class="menu">
		<li><a href="/Slide06lab1demo/depart/list.htm">Manager Depart</a></li>
		<li><a href="/Slide06lab1demo/user/list.htm">Manager User</a></li>
		<li><a href="/Slide06lab1demo/staff/list.htm">Manager Staff</a></li>
		<li><a href="/Slide06lab1demo/record/list.htm">Manager Record</a></li>
	</ul>
	<hr>
	<table border="1">
		<tr>
			<th colspan="4"><h3>Bang Xep Hang Nhan Vien</h3></th>
		</tr>
		<tr>
			<th>ID Staff</th>
			<th>Thanh Tich</th>
			<th>Ky Luat</th>
			<th>Tong Ket</th>
		</tr>
		<c:forEach items="${ListReport}" var="item">
			<tr>
				<td>${item[0]}</td>
				<td>${item[1]}</td>
				<td>${item[2]}</td>
				<td>${item[1]-item[2]}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>