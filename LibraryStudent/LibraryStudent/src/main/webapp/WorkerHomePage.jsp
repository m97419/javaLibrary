<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255" import = "registration.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>library</title>
</head>
<body>
	<form action="/LibraryStudent/Registration.jsp">
		<input type="submit" name="Regist" value="regist">
	</form>
	<form method="post" action="http://localhost:8050/LibraryStudent/MessageServlet">
		<input type="submit" value="To Messages">
	</form>
	<form method="post" action="http://localhost:8050/LibraryStudent/GetBooksServlet">
		<input type="hidden" name="status" value="0">
		<input type="submit" value="Books">
	</form>
</body>
</html>