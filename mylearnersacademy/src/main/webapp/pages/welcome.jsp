<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Creation Page</title>
</head>
<body>
	<center>
		<h2>
			<a href="logout.jsp">Logout</a> 
		</h2>
		<h1>Student Management</h1>
		<h2>
			<a href="createStudent.jsp">Add New Student</a> <a
				href="/mylearnersacademy/student?action=list">List All Students</a>
		</h2>

		<h1>ClassRoom Management</h1>
		<h2>
			<a href="createClass.jsp">Add New Class</a> <a
				href="/mylearnersacademy/classRoom?action=list">List All Classes</a>
		</h2>
		
		<h1>Teacher Management</h1>
		<h2>
			<a href="createTeacher.jsp">Add New Teacher</a> <a
				href="/mylearnersacademy/teacher?action=list">List All Teachers</a>
		</h2>
		
		<h1>Subject Management</h1>
		<h2>
			<a href="createSubject.jsp">Add New Subject</a> <a
				href="/mylearnersacademy/subject?action=list">List All Subjects</a>
		</h2>
	</center>

</body>
</html>