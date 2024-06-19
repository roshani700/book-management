<%@page import="com.jspider.book_management.dto.Book"%>
<%@page import="com.jspider.book_management.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%int id=Integer.parseInt(request.getParameter("id"));
		BookDao bookDao=new BookDao();
		Book book=bookDao.getBookById(id);
	%>

	
	<form action="bookUpdate">
		<input type="number" value=<%=id %> name="id"><br><br>
		<input type="text" value=<%=book.getTitle() %> name="title"><br><br>
		<input type="text" value=<%=book.getAuthor()%> name="author"><br><br>
		<input type="number"  value=<%=book.getPrice()%>  name="price"><br><br>
		<input type="submit" value="Update">
	</form>

</body>
</html>