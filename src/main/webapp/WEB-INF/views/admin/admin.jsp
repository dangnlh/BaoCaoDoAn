<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}
</style>
</head>
<body>

<h1>admin page</h1>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href='<c:url value="dang-nhap"></c:url>'>Schedule Report</a></li>
			
			
			</ul>
		</div>
	</nav>


		 <c:if test="${ not empty inforAccount }">					
						<h5>${ inforAccount.name }</h5>		
						<h5>${ inforAccount.mail }</h5>	
					
						
		</c:if>
		<!--
		 <c:if test="${ not empty getAllScheduleReport }">					
						<h5>${ getAllScheduleReport.id }</h5>		
						<h5>${ getAllScheduleReport.timeReport }</h5>		
					
						
		</c:if>
		
		 <c:if test="${  empty getAllScheduleReport }">					
						<h5>getAllScheduleReport empty</h5>		
					
		</c:if>

  -->



</body>
</html>

