<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Account</title>
</head>
<body>
	<div align="center">
		<h1>Edit Account</h1>
	
	<form:form action="addAccountStudent" method="POST"  modelAttribute="studentAcc">
		<form:hidden path="id" /> 
		AccountID: <form:input path="id"/> <form:errors path="id" cssClass="error"/> <br/><br/>
		
 		<button type="submit">Submit</button>		
 	</form:form>
	</div>
</body>
</html>