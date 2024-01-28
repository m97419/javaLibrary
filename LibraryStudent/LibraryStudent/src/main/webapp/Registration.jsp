<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>library</title>
</head>
<body>
<form method="post" action="http://localhost:8050/LibraryStudent/registration/controller/StudentServlet">
		<table 
			style="width:70%;background-color: skyblue;margin-top:200px;margin-left:100px;margin-right:200px;">

			<tr>
				<td>
					<h3 style="color:brown">Add new user</h3>
				</td>
			</tr>
	        <tr>
				<td>Enter Name:</td>
				<td><input type="text" name="userName"></td>
			</tr>
			 <tr>
				<td>Enter Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Enter Address:</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>Enter Phone Number:</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>Who Are You?</td>
				<td>
					<select name="status">
    				<option value=1>student</option>
    				<option value=2>teacher</option>
    				<option value=0>worker</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="Reg" value="Sign in"></td>
			</tr>
		</table>
	</form>
</body>
</html>