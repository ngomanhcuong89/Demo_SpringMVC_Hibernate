<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<base href="${pageContext.servletContext.contextPath}/">
<style>
	.thongbao
	{
		color:red;
	}
</style>
</head>
<body>
	<c:if test="${not empty thongbao}">
		
		<c:if test="${not empty kiemtra}">
			<p class="thongbao">${thongbao}</p>
			<p class="thongbao">Click <a href="/Slide06lab1demo/home/login.htm">Here</a> To Login Account</p>
		</c:if>
		
		<c:if test="${empty kiemtra}">
			<p class="thongbao">${thongbao}</p>
		</c:if>		
		<p>--------------------------------------------------------------------------------</p>
	</c:if>
	<h1>Create New Account</h1>
	<p>--------------------------------------------------------------------------------</p>
	<form action="/Slide06lab1demo/home/create.htm" method="post" enctype="multipart/form-data">
		<p><input type="text" name="username" placeholder="Username"/></p>
		<p><input type="text" name="password" placeholder="Password"/></p>
		<p>--------------------------------------------------------------------------------</p>
		<p><input type="text" name="id" placeholder="Id"/></p>
		<p><input type="text" name="name" placeholder="Fullname Again"/></p>
		<p> Male<input type="radio" name="gender" value="0"> Female<input type="radio" name="gender" value="1"></p>
		<p><input type="text" name="birthday" placeholder="Birthday"/></p>
		
		<p>Photo</p> <input type="file" name="hinhanh"/>
		
		<p><input type="text" name="email" placeholder="Email"/></p>
		<p><input type="text" name="phone" placeholder="Phone"/></p>
		<p><input type="text" name="salary" placeholder="Salary"/></p>
		<p><textarea name="note" placeholder="Note"></textarea> </p>
		<p>Depart : 
			<select name="departId">
				<c:forEach items="${ListDepart}" var="item">
					<option value="${item.id}">${item.name}</option>
				</c:forEach>
			</select>
		</p>
		<p>--------------------------------------------------------------------------------</p>
		<button>Create Now</button>
	</form>
</body>
</html>