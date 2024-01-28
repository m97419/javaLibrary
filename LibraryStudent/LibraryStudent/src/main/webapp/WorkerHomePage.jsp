<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255" import = "registration.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>library</title>
</head>
<body>
	<form method="post" action="/LibraryStudent/MessageServlet">
		<input type="submit" value="To Messages">
	</form>
	<form method="post" action="/LibraryStudent/GetBooksServlet">
		<input type="hidden" name="status" value="0">
		<input type="submit" value="Books">
	</form>
	<form method="post" action="/LibraryStudent/GetAllUsers">
		<input type="submit" value="Users">
	</form>
</body>
</html>