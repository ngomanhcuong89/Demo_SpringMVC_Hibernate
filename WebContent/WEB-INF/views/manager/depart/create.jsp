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
		<hr>	
	</c:if>
	<h1>Create New Depart</h1>
	<form action="/Slide06lab1demo/depart/save.htm" method="post">
		<p>ID</p>
		<input type="text" name="id" placeholder="ID"/>
		<p>Name</p>
		<input type="text" name="name" placeholder="Name"/>
		<br><br>
		<button>Create Now</button>
	</form>
	<hr>
	<p>Click <a href="/Slide06lab1demo/depart/list.htm">here</a> back list Depart</p>
</body>
</html>