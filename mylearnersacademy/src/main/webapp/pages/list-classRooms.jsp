<%@page import="com.simplilearn.entity.ClassRoom"%>
<%@page import="com.simplilearn.entity.Student"%>
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
<title>Add New Student</title>
</head>
<body>
	<center>
		<h1>Class Room Management</h1>
		<h2>
			<a href="logout.jsp">Logout</a> 
			<a href="createClass.jsp">Add New Class Room</a>
			<table border="1" cellpadding="5">
				<caption>
					<h2>List of Class</h2>
				</caption>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Actions</th>
				</tr>
				<c:forEach var="classRoom" items="${classRooms}">
					<tr>
						<td><c:out value="${classRoom.id}" /></td>
						<td><c:out value="${classRoom.className}" /></td>
						<td><a href="edit?id=<c:out value='${classRoom.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="delete?id=<c:out value='${classRoom.id}' />">Delete</a></td>
					</tr>
				</c:forEach>
	
			</table>
		</h2>
	</center>

</body>
</html>