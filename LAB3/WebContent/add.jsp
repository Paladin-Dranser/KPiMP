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
		Birth:
		<input type="text" name="birth" />
		</label>
		<label>
		Phone:
		<input type="text" name="phone" />
		</label>
		<label>
		City:
		<input type="text" name="city" />
		</label>
		<label>
		Address:
		<input type="text" name="address" />
		</label>
		<input type="submit" value="Add" />
	</form>
</body>
</html>