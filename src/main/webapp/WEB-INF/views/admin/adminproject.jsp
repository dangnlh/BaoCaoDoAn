
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
				<!-- Topbar -->
				<%@include file="/WEB-INF/views/admin/header.jsp"%>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->

				<!-- /.container-fluid -->

				<div class="container-fluid">
					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h4 class="m-0 font-weight-bold text-primary">Project :
								${getAllProject.size()}</h4>
						</div>
						<div class="card-body">
							<div class="table-responsive">
							<a class="nav-link" href='<c:url value="/addProject"/>'>
									<i class="fa fa-plus-square"></i> <span>Add new project</span>
								</a></br>
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<!--  	<th>Code</th> -->
											<th>Name</th>
											<th>URL</th>
											<th>Time Create</th>
											<th>Group</th>
											<th>Group Name</th>
											<th>Teacher</th>
											<th></th>
										</tr>
									</thead>


									<tbody>
										<c:forEach var="item" items="${ getAllProject }">

											<tr>
												<!-- 	<td>${ item.id }</td> -->

												<td>${ item.project_name }</td>
												<td>${ item.urlProject }</td>
												<td>${ item.createTime }</td>
												<td>${ item.group_id }</td>
												<td>${ item.group_name  }</td>
												<td>${ item.teacherId }-${ item.account_name }</td>
												<td> <a

													href='<c:url value="/editProject?id=${ item.id }"/>'
													class="btn btn-success btn-circle btn-sm"> <i
														class="fas fa-edit"></i></a> <a

													href='<c:url value="/deleteProject/${ item.id }"/>'
													class="btn btn-danger btn-circle btn-sm"> <i
														class="fas fa-trash"></i>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>


								</table>
								<!-- nút add cũ (màu xanh lá) -->
								<%-- <a href='<c:url value="/addProject"/>' class="btn btn-success">Add
									Project</a> --%>
							</div>
						</div>
					</div>

				</div>

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@include file="/WEB-INF/views/admin/footer.jsp"%>
			<!-- End of Footer -->
		</div>
	</div>




	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
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

	<!-- Scripts -->
	<%@include file="/WEB-INF/views/admin/adminscript.jsp"%>
	<!-- End of Scripts -->
</body>

</html>