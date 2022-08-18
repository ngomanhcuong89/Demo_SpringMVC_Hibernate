<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty LoginError}">
		<p style="color:red">${LoginError}</p>
	</c:if>
	<h1>Login To Account</h1>
	<form action="/Slide06lab1demo/home/login.htm" method = "post">
		<p><input type="text" name="username" placeholder="Username"/></p>
		<p><input type="password" name="password" placeholder="Password"/></p>
		<button>Login</button>
	</form>
	<p>If you don't have account. Click to <a href="/Slide06lab1demo/home/create.htm">Here</a> Create account </p>
</body>
</html>