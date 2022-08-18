<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ include file="/WEB-INF/views/home/checkUserIsActive.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Record</title>
</head>
<body>
	<c:if test="${not empty requestScope.thongbao}">
		<p style="color:red">${thongbao}</p>
	</c:if>
	<h1>Update Record</h1>
	<form:form modelAttribute="recordupdate" action="/Slide06lab1demo/record/update.htm" method="POST">
		<p>Id</p>
		<form:input path="id"/>
		<p>Type</p>
		<form:radiobuttons path="type" items="${typerecord}" itemValue="typevalue" itemLabel="name"/>
		<p>Reason</p>
		<form:textarea path="reason"/>
		<p>Date</p>
		<fmt:formatDate value="${recordupdate.date}" pattern="MM/dd/YYYY" var="datefmt"/>
		<input type="text" name="date" value="${datefmt }"/>
		<p>Staff</p>
		<form:select path="staffId" items="${liststaff}" itemLabel="name" itemValue="id"/>
		<br><br>
		<form:button>Update</form:button>
	</form:form>
	<hr>
	<p>Click <a href="/Slide06lab1demo/record/list.htm">here</a> Back List Record</p>	
</body>
</html>