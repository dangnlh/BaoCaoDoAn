<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Student Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">
    <img src="bird.jpg" alt="logo" style="width:40px;">
  </a>
  
  <!-- Links -->
  <ul class="navbar-nav">
  
    <li class="nav-item">
      <a class="nav-link" href="#"> Group ${ inforAccount.group_id }</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 2</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 3</a>
    </li>
  </ul>
</nav>
<h1>Student Page</h1>
<h1>Project</h1>

	<div class="container">
		<h5 style="color: red"><a href='<c:url value="dang-nhap/project/byGroupID/${ inforAccount.group_id }">
		</c:url>'>My Project</a></h5>
		
		
	</div>
<h1>Report</h1>
	<div class="container">
		<h5 style="color: red"><a href='<c:url value="dang-nhap/reportSchedule/byAccountID/${ inforAccount.id }">
		</c:url>'>Report Schedule</a></h5>
			
			<h4>Mark Report</h4>
      
</div>
<h1>Profile</h1>
<div class="container">
		 <c:if test="${ not empty inforAccount }">					
					<h5>${ inforAccount.name }</h5>		
						<h5>${ inforAccount.mail }</h5>	
					
						
		</c:if>
      
</div>

</body>
</html>
