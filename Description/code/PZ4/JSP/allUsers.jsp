<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
// Падключаем тэг, створаны ў індывідуальным заданні
<%@ taglib uri="table" prefix="t" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View All Users</title>
</head>
<body>
	<h1>View All Users</h1>
	<a href="home.jsp">Home Page</a>
	<br />
	<c:if test="${isAdmin}">
		<h3>You are Admin</h3>
		<p>
			Count of Users
			<c:out value="${users.size()}" />
        // Выклікаем створаны тэг,
        // які створыць у гэтым месцы html-табліцу карыстальнікаў
		<t:customTable />
	</c:if>
</body>
</html>
