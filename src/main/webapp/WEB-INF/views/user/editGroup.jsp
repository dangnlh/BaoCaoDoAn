<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>NEW / EDIT SCHEDULE</h1>
	
	<form:form action="addAccountInGroup" method="POST"  modelAttribute="group3">
		<form:hidden path="id" /> 
		GroupID: <form:input path="group_id"/> <form:errors path="group_id" cssClass="error"/> <br/><br/>
		
 		<button type="submit">Submit</button>		
 	</form:form>
	</div>
</body>
</html>