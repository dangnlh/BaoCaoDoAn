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
<form:form action="AddGroup" method="POST"  modelAttribute="group4">
	    <form:hidden path="id"/> 
		Name: <form:input path="name"/> <form:errors path="name" cssClass="error"/> <br/><br/>
		
 		<button type="submit">Submit</button>		
</form:form>

</body>
</html>