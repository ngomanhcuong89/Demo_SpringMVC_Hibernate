<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<h1>Update Depart</h1>
	<form:form modelAttribute="departupdate" action="/Slide06lab1demo/depart/update.htm" method="post">
		<p>ID:</p> <form:input path="id"/>
		<p>Name:</p> <form:input path="name"/>
		<br><br>
		<form:button>Update Now</form:button>
	</form:form>
	<hr>
	<p>Click <a href="/Slide06lab1demo/depart/list.htm">here</a> back list Depart</p>	
</body>
</html>