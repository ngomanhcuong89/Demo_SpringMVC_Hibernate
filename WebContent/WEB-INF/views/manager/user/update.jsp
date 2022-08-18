<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
	<h1>User Update</h1>
	<form:form modelAttribute="updateuser" action="/Slide06lab1demo/user/update.htm" method="POST">
		<p>Username</p>
		<form:input path="username"/>
		<p>Password</p>
		<form:input path="password"/>
		<p>Fullname</p>
		<form:input path="fullname"/>
		<p>IsAdmin: 
		<form:radiobuttons path="isadmin" items="${admin}" itemLabel="name" itemValue="result"/></p>
		<p>Staff Id</p>
		<form:select path="staffId" items="${staffs}" itemLabel="name" itemValue="id"/>
		<br><br>
		<form:button>Update</form:button>							
	</form:form>
	<hr>
	<p>Click <a href="/Slide06lab1demo/user/list.htm">here</a> Back List User</p>
</body>
</html>