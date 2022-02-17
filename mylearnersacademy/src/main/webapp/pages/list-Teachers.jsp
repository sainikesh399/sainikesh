<%@page import="com.simplilearn.entity.Teacher"%>
<%@page import="com.simplilearn.entity.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Teacher</title>
</head>
<body>
	<center>
		<h1>Teacher Management</h1>
		<h2>
			<a href="logout.jsp">Logout</a> 
			<a href="createTeacher.jsp">Add New Teacher</a>
			<table border="1" cellpadding="5">
				<caption>
					<h2>List of Teachers</h2>
										
				</caption>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
				<c:forEach var="teacher" items="${teachers}">
					<tr>
						<td><c:out value="${teacher.id}" /></td>
						<td><c:out value="${teacher.name}" /></td>
						<td><c:out value="${teacher.email}" /></td>
						<td><a href="edit?id=<c:out value='${teacher.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="delete?id=<c:out value='${teacher.id}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</h2>
	</center>

</body>
</html>