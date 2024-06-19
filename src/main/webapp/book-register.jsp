<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="book-register.css">


</head>
<body>
	<h1>Book Register Form</h1>
	
	<form action="bookRegister">
		<input type="number" placeholder="Enter Id" name="id"><br><br>
		<input type="text" placeholder="Enter Title" name="title"><br><br>
		<input type="text" placeholder="Enter Author Name" name="author"><br><br>
		<input type="text" placeholder="Enter Price" name="price"><br><br>
		<input type="submit" value="Register">
		
	</form>
	
	
</body>
</html>