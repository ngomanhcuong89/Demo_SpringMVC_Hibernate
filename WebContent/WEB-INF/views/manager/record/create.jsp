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
	<h1>Create A Record</h1>
	<form action="/Slide06lab1demo/record/save.htm" method="POST">
		<p>Type</p>
		Ky luat <input type="radio" name="type" value="false"/>
		Thanh tich <input type="radio" name="type" value="true"/>
		<p>Reason</p>
		<textarea name="reason" rows="" cols=""></textarea>
		<p>Date</p>
		<input type="text" name="date" placeholder="date">
		<p>MM/dd/YYYY</p>
		<p>Staff</p>
		<select name="staffId">
			<c:forEach items="${liststaff}" var="item">
				<option value="${item.id}">${item.name}</option>
			</c:forEach>		
		</select>
		<br><br>
		<button>Create</button>
	</form>
	<hr>
	<p>Click <a href="/Slide06lab1demo/record/list.htm">here</a> Back List Record</p>
</body>
</html>
