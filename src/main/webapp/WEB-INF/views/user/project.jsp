<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
							<button type="button" class="btn btn-success">Edit</button> <a
							href='<c:url value=""/>' class="btn btn-danger">Delete</a>

						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#myModal">Add Project</button>


	

	</div>
</body>
</html>