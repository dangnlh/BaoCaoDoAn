
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Login Form</title>

</head>
<body>
<h1>Login Page</h1>
<h2> ${status}</h2>
<c:if test="${ not empty inforAccount }">
	<h1>${ inforAccount.name }</h1>
	<h1>${ inforAccount.phone }</h1>
</c:if>
	<form:form method="POST" action="/BaoCaoDoAn/dang-nhap" modelAttribute="account">
		<form:input path="mail" type="text" />

		<br>
		<form:input path="password" type="password" />

		<input type="submit" value="Submit" />



	</form:form>
</body>
</html>

