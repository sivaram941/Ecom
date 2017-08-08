 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 ALIGN="CENTER">Registration form</h2>

<form action="Welcome.html" method="post">
<table border="0" align="center">
<tbody>
<tr>
<td><label for="username">User_Name:</label></td>
<td><input id="username" maxlength="50" name="username" type="text" /></td>
</tr>
<tr>
<td><label for="id">Course: </label></td>
<td><input id="id" maxlength="50" name="id" type="text" /></td>
</tr>
<tr>
<td><label for="password">Password:</label></td>
<td><input id="password" maxlength="50" name="password"
type="password" /></td>
</tr>
<tr>
<td><label for="Address">Address:</label></td>
<td><input id="Address" maxlength="50" name="Address" type="text" /></td>
</tr>

<tr>
<td><label for="email">Email_Address:</label></td>
<td><input id="email" maxlength="50" name="email" type="text" /></td>
</tr>
<tr>
<td><label for="Role_user">Role_user:</label></td>
<td><input id="Role_user" maxlength="50" name="Role_user" type="text" /></td>
</tr>
<tr>
<td align="right"><input name="Submit" type="Submit" value="Add" /></td>
</tr>
</tbody>
</table>
</form>
</html>