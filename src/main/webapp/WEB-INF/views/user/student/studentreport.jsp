<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<%@include file="/WEB-INF/views/user/student/linkHeader.jsp"%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"
	type="text/javascript"></script>
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<style>
.container {
    background-color: white!important;
}
</style>
<body>

	<div class="header" th:fragment="headerfrag">
		<!-- -----------------HEADER-------------------- -->
		<%@include file="/WEB-INF/views/user/student/header.jsp"%>
		<!-- -----------------END OF HEADER-------------------- -->
		<!-- -----------------MENU BAR-------------------- -->
		<%@include file="/WEB-INF/views/user/student/menubar.jsp"%>
		<!-- -----------------END OF MENU BAR-------------------- -->
	</div>



	<!-- ---------------------CONTENT--------------------- -->
	<!-- partial:index.partial.html -->
	<div class="container ">
		<c:forEach var="project" items="${ listReport }">
			<c:set var="Report" value="${ project.report }" />
			<h5
				style="text-align: center; text-transform: uppercase; padding: 16px;">${ project.name }</h5>
			<table class="table table-striped project-orders-table">
				<thead>
					<tr>
						<th>Name Schedule</th>
						<th>Point</th>
						<th>Comment</th>
						<th>Time Create</th>
						<th>Time Submit</th>
						<th>URL report</th>
						<th>Action</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${ Report }">
						<tr>
							<td>${ item.name }</td>
							<td>${ item.point }</td>
							<td>${ item.comment }</td>
							<td>${ item.timeCreate }</td>
							<td>${ item.timeSubmit }</td>
							<td>${ item.urlReport }</td>
							<td><a class=""
										href="${pageContext.request.contextPath}/upload_report/${item.id}"
										role="button">Upload</a></td>
					
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:forEach>


	</div>
	<a href="http://www.emilianocostanzo.com" target="_blank" id="sign">EMI</a>
	<!-- partial -->
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script
		src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
	<script src="assets/js/student.js"></script>
	<!-- ---------------------END OF CONTENT--------------------- -->




	<!-- -----------------FOOTER-------------------- -->

	<!-- -----------------END OF FOOTER-------------------- -->
</body>
</html>

