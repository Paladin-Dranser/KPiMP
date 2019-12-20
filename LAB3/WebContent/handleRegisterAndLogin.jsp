<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html, charset=UTF-8">
<title>Verifying Registration</title>
</head>
<body>
	<jsp:useBean id="registeredUser" class="by.bsac.lab3.model.Person"
		scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="registeredUser" />

	<c:set var="userName" value="${registeredUser.name}" />
	<c:set var="userEmail" value="${registeredUser.email}" />
	<c:set var="userPsw" value="${registeredUser.password}" />

	<c:choose>
		<c:when test="${empty userName || empty userEmail || empty userPsw}">
			<h1>
				Not valid Name, Email or Password, please <a href="register.jsp">
					try on more tyme</a>
			</h1>
		</c:when>
		<c:otherwise>
			<%
				session.setAttribute("user", registeredUser.getName());

						if (registeredUser.getRole().equals(by.bsac.lab3.PersonRole.ADMIN)) {
							session.setAttribute("isAdmin", true);
						}

						by.bsac.lab3.dao.SimplePersonDAOImpl.getInstance().add(registeredUser);
						String redirectURL = "http://localhost:8080/LAB3/home.jsp";
						response.sendRedirect(redirectURL);
			%>
		</c:otherwise>
	</c:choose>
</body>
</html>