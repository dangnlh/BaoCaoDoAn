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
<title>ADD SCHEDULE Report</title>
</head>
<body>
	<div align="center">
		<h1>NEW / EDIT SCHEDULE REPORT</h1>
	
	<form:form action="addScheduleReport" method="POST"  modelAttribute="ScheduleReportUpdateAndInsert">
		<form:hidden path="id" /> 
<		Time Create	<form:input path="timeReport" type="date" 
        class="form-control mb-2 mr-sm-2"  />

  	<br/><br/>
		Account ID: <form:input path="account_id"/> <form:errors path="account_id" cssClass="error"/> <br/><br/>
		Report ID: <form:input path="report_id"/> <form:errors path="report_id" cssClass="error"/> <br/><br/>
		Date Submit <form:input path="dateSubmit" type="date" class="form-control mb-2 mr-sm-2" value="2022/06/01" />
 		<button type="submit">Submit</button>		
 	</form:form>
	</div>
</body>
</html>