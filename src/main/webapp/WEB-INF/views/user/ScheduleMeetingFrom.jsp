<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	.error{
		color:red;
		font-size: italic;
	}
</style>
<title>ADD SCHEDULEMETTING</title>
</head>
<body>
	<div align="center">
		<h1>NEW / EDIT SCHEDULE</h1>
	
	<form:form action="addScheduleMeeting" method="POST"  modelAttribute="ScheduleMeeting2">
		<form:hidden path="id" /> 
		timeMeeting	<form:input path="timeMeeting" type="date" class="form-control mb-2 mr-sm-2" value="2022-06-01" />
	<br/><br/>
		Project_ID: <form:input path="project_id"/> <form:errors path="project_id" cssClass="error"/> <br/><br/>
		Account_id: <form:input path="account_id"/> <form:errors path="account_id" cssClass="error"/> <br/><br/>
		Name SheduleMeeting <form:input path="name"/> <form:errors path="name" cssClass="error"/> <br/><br/>
		Link Meeting <form:input path="link_meeting"/> <form:errors path="link_meeting" cssClass="error"/> <br/><br/>
		Content <form:input path="content"/> <form:errors path="content" cssClass="error"/> <br/><br/>
		Date Submit <form:input path="submitDate" type="date" class="form-control mb-2 mr-sm-2" value="2022-06-01" />
 		<button type="submit">Submit</button>		
 	</form:form>
	</div>
</body>
</html>