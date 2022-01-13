
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
	<c:forEach var="item" items="${ login }">
		<h1>${ item.mail }</h1>
		<h1>${ item.password }</h1>
	</c:forEach>

<h1>${ message }</h1>
<h1>${ message2 }</h1>
<form  method="POST" action="doLogin" >
			<input type="text" name="mail"/>
			<br>
			<input type="password" name="password" />
			<input type="submit" value="Submit" />
		<div style="color: red">${error}</div>


	</form>
	
</body>
</html>

