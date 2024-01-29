<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>library</title>
</head>
<body>
<form method="post" action="http://localhost:8050/LibraryStudent/AddMessageServlet">
	Enter Message:
	<input type="text" name="txt">
	<input type="hidden" name="userId" value="18">
	<input type="submit" name="add" value="ADD">
</form>
</body>
</html>