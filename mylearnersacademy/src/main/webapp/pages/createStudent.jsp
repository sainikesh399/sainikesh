<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Student</title>
</head>
<body>
		<center>
		<h1>Student Management</h1>
		<h2>
			<a href="logout.jsp">Logout</a> 
			<a href="/mylearnersacademy/student?action=list">List All Students</a>
			<form action="/mylearnersacademy/student" method="post">
				<table border="1" cellpadding="10">
					<h1>Add New Student</h1>
					<tr>
						<th>Name</th>
						<td><input type="text" name="studentName"></td>
					</tr>
					<tr>
						<th>Email</th>
						<td><input type="email" name="email"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<input type="hidden"  name="action" value="new"/>
						<input type="submit" value="Add Student" /></td>
					</tr>
				</table>
			</form>
		</h2>
	</center>

</body>
</html>