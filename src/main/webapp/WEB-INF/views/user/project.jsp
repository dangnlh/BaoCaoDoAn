<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>



	<div class="container">
		<h2>Project</h2>

		<table class="table table-striped" border="1">


			<thead>
				<tr>
					<th>Code</th>
					<th>Name</th>
					<th>URL</th>
					<th>Time Create</th>
					<th>Group</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${ getAllProject }">

					<tr>
						<td>${ item.id }</td>

						<td>${ item.name }</td>
						<td>${ item.urlProject }</td>
						<td>${ item.createTime }</td>
						<td>${ item.group_id }</td>
						<td>
					
					    <a  href='<c:url value="/edit/${ item.id }"/>' class="btn btn-success" >Edit</a>
					    <a href='<c:url value="/deleteProject/${ item.id }"/>' class="btn btn-danger">Delete</a>
							

						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#modalAddProject">Add Project</button>


	
		<div class="modal" id="modalAddProject" >
			<div class="modal-dialog">
				<div class="modal-content">

					
					<div class="modal-header">
						<h4 class="modal-title">Add New Project</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

				
					<div class="modal-body">
					
							<form:form method="POST" action="add-project" modelAttribute="project" >
							<label for="email2" class="mb-2 mr-sm-2">Name Project</label> <br>
							 <form:input path="name" type="text" class="form-control mb-2 mr-sm-2" />
								 <br>
								
								 
								 <label for="email2" class="mb-2 mr-sm-2">UrL Porject</label> <br>
								<form:input path="urlProject" type="text" class="form-control mb-2 mr-sm-2" />
							 <br> 
								
								
								 <label for="email2" class="mb-2 mr-sm-2">Time Create </label> <br>
								<form:input path="createTime" type="date" class="form-control mb-2 mr-sm-2" value="2022-06-01" />
							 <br>
							 
							 	 <label for="email2" class="mb-2 mr-sm-2">Group</label> <br>
								<form:input path="group_id" type="text" class="form-control mb-2 mr-sm-2" />
							 <br> 
							 
							 
								<button type="submit" class="btn btn-primary mb-2">Submit</button>

						</form:form>

					</div>

				
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>

				</div>
			</div>
		</div>
		
		
		
	<!--EDIT  -->	


	

	</div>
</body>
</html>