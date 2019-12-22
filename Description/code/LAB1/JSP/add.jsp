<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Page</title>
</head>
<body>
	<form action="add" method="post">
		<label>
		FirstName:
		<input type="text" name="firstname" />
		</label>
		<label>
		LastName:
		<input type="text" name="lastname" />
		</label>
		<label>
		Salary:
		<input type="text" name="salary" />
		</label>
		<input type="submit" value="Add" />
	</form>
</body>
</html>