<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h1>
		Hello,
		<%=session.getAttribute("user")%>
		<%=session.getAttribute("password") %>
		<%=session.getAttribute("loginData") %>
	</h1>
	
	<form action="search" method="post">
		<label>
		Search
		<input type="text" name="search" />
		<input type="submit" value="Search" />
		</label>
	</form>
	
	<form action="logout" method="post">
		<input type="hidden" name="authAction" value="logout">
		<input type="submit" value="Logout" />
	</form>
</body>
</html>