<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/views/home/checkUserIsActive.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<base href="${pageContext.servletContext.contextPath}/" />
</head>
<body>
	<c:if test="${not empty thongbao}">
		<p style="color:red">${thongbao}</p>
	</c:if>
	
	<h1>Edit Staff</h1>
	<form:form modelAttribute="staffupdate" action="/Slide06lab1demo/staff/update.htm" method="POST" enctype="multipart/form-data">
		<p>ID</p> <form:input path="id"/>
		<p>Name</p> <form:input path="name"/>
		<p>Gender: <form:radiobuttons path="gender" items="${listgender}" itemLabel="name" itemValue="gendervalue"/></p> 
		
		<fmt:formatDate value="${staffupdate.birthday}" pattern="dd/MM/yyyy" var="formatdate"/>
		<p>Birthday</p> <input type="text" name="birthday" value="${formatdate}"/>
		
		<input type="hidden" name="photo" value="${staffupdate.photo }"/>
		<p>Photo</p> <img src="hinhanh/${staffupdate.photo}" style="width:150px;heigth:150px"/>
		<p>Edit Photo:</p> <input type="file" name="photonew">
		
		<p>Email</p> <form:input path="email"/>
		<p>Phone</p> <form:input path="phone"/>
		<p>Salary</p> <form:input path="salary"/>
		<p>Note</p> <form:textarea path="note"/>
		<p>Depart</p> <form:select path="departId" items="${listdepart}" itemLabel="name" itemValue="id"/>
		<br><br>
		<form:button>Update</form:button>
	</form:form>
	<hr>
	<p>Click <a href="/Slide06lab1demo/staff/list.htm">here</a> Back List Staff</p>
</body>
</html>