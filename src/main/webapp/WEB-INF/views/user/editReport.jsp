<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<c:forEach var="item" items="${ getReport }">
	<form:form method="POST" action="" modelAttribute="report" >
						
							<label for="email2" class="mb-2 mr-sm-2">Name Report</label> <br>
							
							<form:input path="name" type="text" class="form-control mb-2 mr-sm-2" placeholder="Name Report" 
							value="${ item.name }" />
							
							 <br><br> 
							
								<label for="pwd2" class="mb-2 mr-sm-2">Time Create</label> <br>
								<form:input path="timeCreate" type="date" class="form-control mb-2 mr-sm-2" value="${ item.timeCreate }" />
								 <br> <br>
								 
								 <label for="pwd2" class="mb-2 mr-sm-2">Time Submit</label> <br>
								 <form:input path="timeSubmit" type="date" class="form-control mb-2 mr-sm-2" value="${ item.timeSubmit }" />
								 <br> <br>
								 
								 <label for="email2" class="mb-2 mr-sm-2">URL Report</label> <br>
								 <form:input path="urlReport" type="text" class="form-control mb-2 mr-sm-2" value="${ item.urlReport }" />
								 <br> <br> 
								
								 <label for="email2" class="mb-2 mr-sm-2">Project</label> <br>
								 <form:input path="project_id" type="text" class="form-control mb-2 mr-sm-2" value="${ item.project_id }" />
								 <br> <br> 
								
									
								<button type="submit" class="btn btn-primary mb-2">Submit</button>
								

						
						</form:form>
</c:forEach>
					
						</div>

</body>
</html>