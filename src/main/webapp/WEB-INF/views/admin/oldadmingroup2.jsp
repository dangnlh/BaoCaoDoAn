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
<title>Group Page</title>
<!-- Custom fonts for this template-->
<%@include file="/WEB-INF/views/admin/linkheader.jsp"%>
</head>

<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="/WEB-INF/views/admin/sidebar.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">

				<!-- Header -->
				<%@include file="/WEB-INF/views/admin/header.jsp"%>
				<!-- End of Header -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Group</h1>
						<!-- <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a> -->

					</div>

					<!-- Content Row -->
					<!-- 					<div class="row"> -->






					<div class="container">
						<h1>KIET</h1>
						<a href="AddGroup">Add Group</a>
						<c:forEach var="items" items="${ group4 }" varStatus="counter">
							<c:if test="${not empty items }" />

							<table border="2" cellpadding="7">
								<thead>
									<tr>
										<th>.NO</th>
										<th>ID</th>
										<th>Name</th>
										<th>ViewProject</th>
										<th>ViewStudent</th>
										<th>DELETE</th>
										<th>Edit</th>

									</tr>
								</thead>
								<tbody>
									<tr>
										<td>${counter.index + 1 }</td>
										<td>${ items.id }</td>
										<td>${ items.name }</td>
										<td><a
											href='<c:url value="Project/${ items.id }"></c:url>'>ViewProject</a></td>
											
										<td><a href='<c:url value="group/${ items.id }"></c:url>'>ViewStudent</a></td>
										
										<td><a
											href='<c:url value="/deleteGroup?id=${items.id}"></c:url>'>DELETE</a></td>
											
										<td><a
											href='<c:url value="/editgroup?id=${items.id}"></c:url>'>Edit</a></td>
									</tr>
								</tbody>
							</table>

						</c:forEach>





					</div>


					<div class="container"></div>
					<!-- Content Row -->

					<div class="row"></div>

					<div class="col-lg-6 mb-4"></div>
					<!-- /.container-fluid -->
				</div>
				<!-- End of Main Content -->

				<!-- Footer -->
				<%@include file="/WEB-INF/views/admin/footer.jsp"%>
				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->
		</div>
		<!-- End of Page Wrapper -->

		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">Ã</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
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