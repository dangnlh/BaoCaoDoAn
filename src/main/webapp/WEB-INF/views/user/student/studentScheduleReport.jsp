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
		
<div class="row">


						<div class="col-lg-12 grid-margin stretch-card">
							<div class="card">
								<div class="table-responsive pt-3">
									<h4 style="text-transform: uppercase; padding: 16px;">Your
										Schedule Report</h4>
									<table class="table table-striped project-orders-table">
										<thead>
											<tr>
												
												<th>Report Name</th>
												<th>Time Report</th>
											</tr>
										</thead>
										<tbody>
									
											<tr> 
											
										
										
										
											<c:forEach var="scheduleReport" items="${ StudentScheduleReports }">
													<c:set var="report" value="${scheduleReport.report}" />
													
												<tr> 
													<td>${report.name}</td>
													<td>${scheduleReport.timeReport}</td>
												
									
												</tr>
											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>

						</div>

					</div>


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



