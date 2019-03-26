<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Its Error</h3>
<c:choose>
		<c:when test="${empty username}">
			<h2>Access Denied!</h2>
		</c:when>
		<c:otherwise>
			<h2>Username : ${username} <br/>You do not have access to resource!</h2>
		</c:otherwise>
	</c:choose>
</body>
</html>