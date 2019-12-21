<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
// Падключаем стандартныя jstl тэгі, для карыстання c:if і c:for
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
// Падключаем стандартны jstl тэг, для карыстання fmt:formatDate
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
        // Загалоўкі табліцы
		<table width="100%" border="1">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Role</th>
				<th>Last login date</th>
			</tr>
            // Перабіраем кожнага карыстальніка ў
            // пераменнай users (бярэцца з сесіі),
            // якая ўяўляе сабою спіс аб'ектаў Person
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.role}</td>
                    // Прявараем ці аўтэнтыфікаваўся бягучы карыстальнік
                    // калі аўтэнтыфікаваўся, выводзім дату аўтэнтыфікацыі,
                    // інакш - надпіс User did not login
					<td><c:if test="${user.loginDate==null}">User did not login</c:if>
					<c:if test="${user.loginDate!=null}"><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${user.loginDate}"/></c:if></td>
				</tr>
			</c:forEach>
		</table>
		</p>
	</c:if>
</body>
</html>
