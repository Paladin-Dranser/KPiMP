<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html, charset=UTF-8">
<title>Register new user</title>
</head>
<body>
	<h1>Register new user</h1>
	<form action="handleRegisterAndLogin.jsp" method="post">
		<p>
			<label for="email">Email</label> <input type="text" name="email" />
		<p>
			<label for="name">Name</label> <input type="text" name="name" />
		<p>
			<label for="password">Password</label> <input type="password"
				name="password" />
		<p>
			<label for="admin">Admin</label> 
			<input type="radio" name="role" value="ADMIN" id="admin" />
			<label for="user">User</label>
			<input
				type="radio" name="role" value=REGISTERED id="user" checked />
		<p>
			<input type="submit" value="Register" />
	</form>
</body>
</html>
