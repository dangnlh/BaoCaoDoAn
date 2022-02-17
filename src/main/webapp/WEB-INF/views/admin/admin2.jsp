<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Admin Page</title>
<!-- Custom fonts for this template-->
<link
	href="<c:url value="/assets/vendor/fontawesome-free/css/all.min.css" /> "
	rel="stylesheet" />

<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<link href="<c:url value="/assets/css/sb-admin-2.min.css" /> "
	rel="stylesheet" />



</head>

<body id="page-top">	
	<div id="wrapper">		
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">			
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center" href="/admin">
				<div class="sidebar-brand-icon">
					<img src="" alt="FPT" style="max-width: 140px;">
				</div> 
			</a>
			<hr class="sidebar-divider my-0">	
			<li class="nav-item active"><a class="nav-link" href="/admin">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li>
			<hr class="sidebar-divider">
		
			<div class="sidebar-heading">Website-Manager</div>
			<li class="nav-item">
			<li class="nav-item"><a class="nav-link" href="/posts"> <i
					class="fas fa-fw fa-table"></i> <span>Student</span></a></li>
			
			<li class="nav-item">
			
			<a class="nav-link" href='<c:url value="/ScheduleReport"></c:url>'> <i class="fas fa-fw fa-table"></i> <span>Schedule Report</span></a>
	
			</li>
			<li class="nav-item">
			
			<a class="nav-link" href='<c:url value="/ScheduleMeeting"></c:url>'> <i class="fas fa-fw fa-table"></i> <span>Schedule Meeting</span></a>
	
			</li>
			
			<li class="nav-item"><a class="nav-link"
				href='<c:url value="/Project"></c:url>'> <i class="fas fa-fw fa-table"></i> <span>Project</span></a>

	</li>
				<li class="nav-item">
				<a class="nav-link" href='<c:url value="/ListGroup"></c:url>'> <i class="fas fa-fw fa-table"></i> <span>Group</span></a>
	</li>
			
			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>
		</ul>		
	
		</div>
	


	
		

	
		<script src="/assets/vendor/jquery/jquery.min.js"></script>
		<script src="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<script src="/assets/vendor/jquery-easing/jquery.easing.min.js"></script>	
		<script src="/assets/js/sb-admin-2.min.js"></script>	
		<script src="/assets/vendor/chart.js/Chart.min.js"></script>
		<script src="/assets/js/demo/chart-area-demo.js"></script>
		<script src="/assets/js/demo/chart-pie-demo.js"></script>
</body>

</html>