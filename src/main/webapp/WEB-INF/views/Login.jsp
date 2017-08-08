<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="/login_page.php">
  <div class="container">
    <label><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>
     <label><b>id</b></label>
    <input type="text" placeholder="Enter id" name="id" required>
    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
     <label><b>Address</b></label>
    <input type="text" placeholder="Enter Address" name="email" required>
    <label><b>email</b></label>
    <input type="text" placeholder="Enter email" name="email" required>
     <label><b>Role_user</b></label>
    <input type="text" placeholder="Enter Role_user" name="Role_user" required>
    <button type="submit">Login</button>
    <input type="checkbox" checked="checked"> Remember me
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
</form>

</body>
</html>