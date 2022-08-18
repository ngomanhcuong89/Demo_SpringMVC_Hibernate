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
	<h1>Create New Staff</h1>
	<form action="/Slide06lab1demo/staff/add.htm" method="POST" enctype="multipart/form-data">
		<p>ID</p>
		<input type="text" name="id" placeholder="Id"/>
		<p>Name: </p>
		<input type="text" name="name" placeholder="Name"/>
		<p>Gender:
		Male <input type="radio" name="gender" value="false"/>
		Female <input type="radio" name="gender" value="true"/>
		</p>
		<p>Birthday</p>
		<input type="text" name="birthday" placeholder="Birthday">
		<p>MM/dd/YYYY</p>
		<p>Photo</p>
		<input type="file" name="photonew"/>
		<p>Email</p>
		<input type="text" name="email" placeholder="Email"/>
		<p>Phone</p>
		<input type="text" name="phone" placeholder="Phone"/>
		<p>Salary</p>
		<input type="text" name="salary" placeholder="Salary"/>
		<p>Note</p>
		<textarea name="note"></textarea>
		<p>Depart</p>
		<select name="departId">
			<c:forEach items="${listdepart}" var="item">
				<option value="${item.id}">${item.name}</option>
			</c:forEach>
		</select>
		<br><br>
		<button>Create</button>
	</form>
	<hr>
	<p>Click <a href="/Slide06lab1demo/staff/list.htm">here</a> Back List Staff</p>
</body>
</html>