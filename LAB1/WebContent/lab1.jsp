<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Individual Page</title>
</head>
<body>
	<form action="lab1" method="post">
		<select name="triga">
    		<option value="cos">Cos</option>
    		<option value="sin">Sin</option>
    	</select>
    	
    	<label>
			Calculate
			<input type="text" name="calculate" />
			<input type="submit" value="Calculate" />
		</label>
	</form>
</body>
</html>