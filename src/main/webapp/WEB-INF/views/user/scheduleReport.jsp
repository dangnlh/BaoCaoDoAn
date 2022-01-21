<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1 style="color: red">All Report</h1>
	<c:forEach var="item" items="${ getAllReport }">
		<h1>ID: ${ item.id }</h1>
		<h1>Name: ${ item.name }</h1>
		<h1>timeReport: ${ item.timeCreate }</h1>
		<h1>timeSubmit: ${ item.timeSubmit }</h1>
		<h1>project_id: ${ item.project_id  }</h1>
	</c:forEach>


	<h1 style="color: red">Schedule Report</h1>
	<c:forEach var="item" items="${ getAllScheduleReport }">
		<h1>ID: ${ item.id }</h1>
		<h1>Account_id: ${ item.account_id }</h1>
		<h1>timeReport: ${ item.timeReport }</h1>
	</c:forEach>



		
			<form:form method="POST" action="/BaoCaoDoAn/add"  modelAttribute="schduleReport">
					<form:input path="timeReport"  type="text" />			
					<form:input path="account_id"  type="text" />	
					<form:input path="report_id"  type="text" />	

			
				<input type="submit" value="Add Schedule Report ">
			
		 </form:form>

<h1 style="color: red">${ success }</h1>
</body>
</html>