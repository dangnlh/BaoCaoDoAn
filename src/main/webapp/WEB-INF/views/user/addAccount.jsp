<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Account</title>
</head>
<body>
<form:form action="addAccountStudent" method="POST"  modelAttribute="studentAcc1">
	    <form:hidden path="id"/> 	
		Name: <form:input path="name"/> <form:errors path="name" cssClass="error"/></br>
		Mail: <form:input path="mail"/> <form:errors path="mail" cssClass="error"/></br>
		Password: <form:input path="password"/> <form:errors path="password" cssClass="error"/></br>
		Group ID: <form:input path="group_id"/> <form:errors path="group_id" cssClass="error"/></br>
		Phone: <form:input path="phone"/> <form:errors path="phone" cssClass="error"/></br>
		Role: <form:input path="role"/> <form:errors path="role" cssClass="error"/></br>
		Leader: <form:input path="isLeader"/> <form:errors path="isLeader" cssClass="error"/></br>
		Gender: <form:input path="gender"/> <form:errors path="gender" cssClass="error"/></br>
 		<button type="submit">Submit</button>		
</form:form>

</body>
</html>