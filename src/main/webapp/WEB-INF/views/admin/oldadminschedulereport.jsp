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
<!-- Custom styles for this template-->


</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="/admin">
				<div class="sidebar-brand-icon">
					<img src="" alt="FPT" style="max-width: 140px;">
				</div> <!-- <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div> -->
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item"><a class="nav-link" href="/admin"> <i
					class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">



			<!-- Heading -->
			<div class="sidebar-heading">Website-Manager</div>


			<!-- Nav Item - Tables -->

			<li class="nav-item">
			<li class="nav-item"><a class="nav-link" href="/posts"> <i
					class="fas fa-fw fa-table"></i> <span>Student</span></a></li>

			<li class="nav-item active"><a class="nav-link"
				href='<c:url value="/ScheduleReport"></c:url>'> <i
					class="fas fa-fw fa-table"></i> <span>Schedule Report</span></a></li>
			<li class="nav-item"><a class="nav-link"
				href='<c:url value="/ScheduleMeeting"></c:url>'> <i
					class="fas fa-fw fa-table"></i> <span>Schedule Meeting</span></a></li>

			<li class="nav-item"><a class="nav-link"
				href='<c:url value="/Project"></c:url>'> <i
					class="fas fa-fw fa-table"></i> <span>Project</span></a></li>


			<li class="nav-item"><a class="nav-link"
				href='<c:url value="/ListGroup"></c:url>'> <i
					class="fas fa-fw fa-table"></i> <span>Group</span></a></li>

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>



		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->

		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>



					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>



						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">Department</span>
								<img class="img-profile rounded-circle"
								src="images/undraw_profile.svg">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<!-- <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a> -->
								<!-- <div class="dropdown-divider"></div> -->
								<a class="dropdown-item" href="/logout"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>

				<div class="container-fluid">






					<div class="container">
						<h2>Schedule Report</h2>

						<table class="table table-striped" border="1">


							<thead>
								<tr>
									<th>Code</th>
									<th>Time Create</th>
									<th>Code Report</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${ getAllScheduleReport }">
									<tr>
										<td>${ item.id }</td>

										<td>${ item.timeReport }</td>
										<td>${ item.report_id }</td>
										<td>
											<button type="button" class="btn btn-success">Edit</button> <a
											href='<c:url value="/deleteScheduleReport/${ item.id }"/>'
											class="btn btn-danger">Delete</a>

										</td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
						 <h3><a class="btn btn-primary"  href='<c:url value="/new"/>'>New Customer</a></h3>
					
					

		

					</div>


					<div class="container">
						<h2>Report</h2>

						<table class="table table-striped" border="1">


							<thead>
								<tr>
									<th>Code</th>
									<th>Name</th>
									<th>Point</th>
									<th>Comment</th>
									<th>Time Create</th>
									<th>Time Submit</th>
									<th>Code Project</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${ getAllReport }">
									<tr>
										<td>${ item.id }</td>
										<td>${ item.name }</td>
										<td></td>
										<td></td>
										<td>${ item.timeCreate }</td>
										<td>${ item.timeSubmit }</td>
										<td>${ item.project_id  }</td>
										<td><a class="btn btn-success"
											href='<c:url value="/editReport/${ item.id }"></c:url>'>Edit</a>






											<a href='<c:url value="/deleteReport/${ item.id }"/>'
											class="btn btn-danger">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
						<a class="btn btn-primary" data-toggle="modal"
							data-target="#myModal2">Add Report</a>


						<div class="modal" id="myModal2">
							<div class="modal-dialog">
								<div class="modal-content">


									<div class="modal-header">
										<h4 class="modal-title">Add New Report</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>


									<div class="modal-body">
										<form:form method="POST" action="addreport"
											modelAttribute="report">

											<label for="email2" class="mb-2 mr-sm-2">Name Report</label>
											<br>
											<form:input path="name" type="text"
												class="form-control mb-2 mr-sm-2" placeholder="Name Report" />
											<br>
											<br>

											<label for="pwd2" class="mb-2 mr-sm-2">Time Create</label>
											<br>
											<form:input path="timeCreate" type="date"
												class="form-control mb-2 mr-sm-2" value="2022-06-01" />
											<br>
											<br>

											<label for="pwd2" class="mb-2 mr-sm-2">Time Submit</label>
											<br>
											<form:input path="timeSubmit" type="date"
												class="form-control mb-2 mr-sm-2" value="2022-06-01" />
											<br>
											<br>

											<label for="email2" class="mb-2 mr-sm-2">URL Report</label>
											<br>
											<form:input path="urlReport" type="text"
												class="form-control mb-2 mr-sm-2"
												placeholder="Content Report" />
											<br>
											<br>

											<label for="email2" class="mb-2 mr-sm-2">Project</label>
											<br>
											<form:input path="project_id" type="text"
												class="form-control mb-2 mr-sm-2" placeholder="For Project" />
											<br>
											<br>


											<button type="submit" class="btn btn-primary mb-2">Submit</button>



										</form:form>
									</div>


									<div class="modal-footer">
										<button type="button" class="btn btn-danger"
											data-dismiss="modal">Close</button>
									</div>

								</div>
							</div>
						</div>

					</div>
					<!-- Content Row -->

					<div class="row">



					</div>

					<div class="col-lg-6 mb-4">




					</div>
				</div>

			</div>
	

		</div>
	

	</div>


	</div>


	
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">Ã</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="/assets/vendor/jquery/jquery.min.js"></script>
	<script src="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/assets/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="/assets/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="/assets/js/demo/chart-area-demo.js"></script>
	<script src="/assets/js/demo/chart-pie-demo.js"></script>
</body>

</html>