<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>library</title>
</head>
<body>
	<form method="post" action="http://localhost:8050/LibraryStudent/registration/controller/LoginServlet">
		<table 
			style="width:70%;background-color: skyblue;margin-top:200px;margin-left:100px;margin-right:200px;">

			<tr>
				<td>
					<h3 style="color:brown">Hello user!</h3>
				</td>
			</tr>
	        <tr>
				<td>Enter User Name :</td>
				<td><input type="text" name="userName"></td>
			</tr>
			 <tr>
				<td>Enter Password :</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="Login" value="login"></td>
			</tr>
		</table>
		<!-- <div style="visibility:hidden;margin-left:100px;" id="wrong">User name or password are wrong</div> -->
	</form>
</body>
</html>