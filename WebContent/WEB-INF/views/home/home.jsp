<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="checkUserIsActive.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.user.isadmin == true}">
		<c:redirect url="/home/manager.htm"/>
	</c:if>
	
	<c:if test="${sessionScope.user.isadmin == false}">
		<c:redirect url="/home/staff.htm"/>
	</c:if>
</body>
</html>