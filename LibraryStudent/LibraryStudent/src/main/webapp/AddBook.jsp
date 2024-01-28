<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>library</title>
</head>
<body>
<form method="post" action="http://localhost:8050/LibraryStudent/AddBookServlet">
		<table 
			style="width:70%;background-color: skyblue;margin-top:200px;margin-left:100px;margin-right:200px;">

			<tr>
				<td>
					<h3 style="color:brown">Add new book</h3>
				</td>
			</tr>
	        <tr>
				<td>Enter Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			 <tr>
				<td>Enter Author:</td>
				<td><input type="text" name="author"></td>
			</tr>
			<tr>
				<td>Enter Description:</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<input type="hidden" name="status" value="0">
				<td><input type="submit" name="add" value="ADD"></td>
			</tr>
		</table>
	</form>
</body>
</html>