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
					<td><a href='<c:url value="Project/${ items.id }"></c:url>'>ViewProject</a></td>
					<td><a href='<c:url value="group/${ items.id }"></c:url>'>ViewStudent</a></td>
					<td><a href='<c:url value="/deleteGroup?id=${items.id}"></c:url>'>DELETE</a></td>
					<td><a href='<c:url value="/editgroup?id=${items.id}"></c:url>'>Edit</a></td>
				</tr>
			</tbody>
		</table>
	
	</c:forEach>
	<a href="AddGroup">Add Group</a>
<%-- 	<h1 align="center">List Student</h1>
	<c:forEach var="item" items="${ group3 }" varStatus="counter">
		
		<c:if test="${not empty item }" />
		<div align="center">
			
			<table border="2" cellpadding="7">
				<thead>
					<tr>
						<th>.NO</th>
						<th>ID</th>
						<th>Name</th>
						<th>Mail</th>
						<th>Role</th>
						<th>GroupID</th>
						<th>DELETE</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${counter.index + 1 }</td>
						<td>${ item.id }</td>
						<td>${ item.name }</td>
						<td>${ item.mail }</td>
						<td>${ item.role }</td>
						<td>${ item.group_id }</td>

						<td><a href='<c:url value="/editAccount?id=${item.id}"></c:url>'>Edit</a></td>
					</tr>
				</tbody>
			</table>
		</div>


	</c:forEach>




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
						<td>
						<a class="btn btn-success" href='<c:url value="/editReport/${ item.id }"></c:url>'>Edit</a>
						
				

				
							
						
							<a href='<c:url value="/deleteReport/${ item.id }"/>' class="btn btn-danger">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<a class="btn btn-primary" data-toggle="modal"
			data-target="#myModal2">Add Report</a>
		
		
		<div class="modal" id="myModal2" >
			<div class="modal-dialog">
				<div class="modal-content">

					
					<div class="modal-header">
						<h4 class="modal-title">Add New Report</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

				
					<div class="modal-body">
							<form:form method="POST" action="addreport" modelAttribute="report" >
							
							<label for="email2" class="mb-2 mr-sm-2">Name Report</label> <br>
							<form:input path="name" type="text" class="form-control mb-2 mr-sm-2" placeholder="Name Report" />
							 <br><br> 
								
								<label for="pwd2" class="mb-2 mr-sm-2">Time Create</label> <br>
								<form:input path="timeCreate" type="date" class="form-control mb-2 mr-sm-2" value="2022-06-01" />
								 <br> <br>
								 
								 <label for="pwd2" class="mb-2 mr-sm-2">Time Submit</label> <br>
								 <form:input path="timeSubmit" type="date" class="form-control mb-2 mr-sm-2" value="2022-06-01" />
								 <br> <br>
								 
								 <label for="email2" class="mb-2 mr-sm-2">URL Report</label> <br>
								 <form:input path="urlReport" type="text" class="form-control mb-2 mr-sm-2" placeholder="Content Report" />
								 <br> <br> 
								
								 <label for="email2" class="mb-2 mr-sm-2">Project</label> <br>
								 <form:input path="project_id" type="text" class="form-control mb-2 mr-sm-2" placeholder="For Project" />
								 <br> <br> 
								
									
								<button type="submit" class="btn btn-primary mb-2">Submit</button>
								

						
						</form:form>
					</div>

				
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>

				</div>
			</div>
		</div>

	</div>
					<!-- Content Row -->

					<div class="row">

						<!-- Area Chart -->
						<!-- <div class="col-xl-8 col-lg-7">
                            <div class="card shadow mb-4">
                                Card Header - Dropdown
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">Earnings Overview</h6>
                                    <div class="dropdown no-arrow">
                                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                                            aria-labelledby="dropdownMenuLink">
                                            <div class="dropdown-header">Dropdown Header:</div>
                                            <a class="dropdown-item" href="#">Action</a>
                                            <a class="dropdown-item" href="#">Another action</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">Something else here</a>
                                        </div>
                                    </div>
                                </div> -->
						<!-- Card Body -->
						<!-- <div class="card-body">
                                    <div class="chart-area">
                                        <canvas id="myAreaChart"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div> -->

						<!-- Pie Chart -->
						<!-- <div class="col-xl-4 col-lg-5">
                            <div class="card shadow mb-4">
                                Card Header - Dropdown
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">Revenue Sources</h6>
                                    <div class="dropdown no-arrow">
                                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                                            aria-labelledby="dropdownMenuLink">
                                            <div class="dropdown-header">Dropdown Header:</div>
                                            <a class="dropdown-item" href="#">Action</a>
                                            <a class="dropdown-item" href="#">Another action</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">Something else here</a>
                                        </div>
                                    </div>
                                </div> -->
						<!-- Card Body -->
						<!-- <div class="card-body">
                                    <div class="chart-pie pt-4 pb-2">
                                        <canvas id="myPieChart"></canvas>
                                    </div>
                                    <div class="mt-4 text-center small">
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-primary"></i> Direct
                                        </span>
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-success"></i> Social
                                        </span>
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-info"></i> Referral
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> -->

						<!-- Content Row -->
<!-- 						<div class="row"> -->

							

								

							</div>

							<div class="col-lg-6 mb-4">

								

								<!-- Approach -->
								<!-- <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Development Approach</h6>
                                </div>
                                <div class="card-body">
                                    <p>SB Admin 2 makes extensive use of Bootstrap 4 utility classes in order to reduce
                                        CSS bloat and poor page performance. Custom CSS classes are used to create
                                        custom components and custom utility classes.</p>
                                    <p class="mb-0">Before working with this theme, you should become familiar with the
                                        Bootstrap framework, especially the utility classes.</p>
                                </div>
                            </div> -->
					<!-- Add Group Button -->
					<a href="AddGroup" style="font-size: 30px;">Add Group</a>
					<!-- End of Add Group Button -->

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Group Detail</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>.NO</th>
											<th>ID</th>
											<th>Name</th>
											<th>ViewProject</th>
											<th>ViewStudent</th>
											<th>Action</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>.NO</th>
											<th>ID</th>
											<th>Name</th>
											<th>ViewProject</th>
											<th>ViewStudent</th>
											<th>Action</th>
										</tr>
									</tfoot>
									<tbody>
										<c:forEach var="items" items="${ group4 }" varStatus="counter">
											<c:if test="${not empty items }" />
											<tr>
												<td>${counter.index + 1 }</td>
												<td>${ items.id }</td>
												<td>${ items.name }</td>
												<td><a href='<c:url value="Project/${ items.id }"></c:url>'>ViewProject</a></td>
												<td><a href='<c:url value="group/${ items.id }"></c:url>'>ViewStudent</a></td>
												<td><a href='<c:url value="/editgroup?id=${items.id}"></c:url>'
													class="btn btn-success btn-circle btn-sm"> <i
														class="fas fa-check"></i>
												</a> <a href='<c:url value="/deleteGroup?id=${items.id}"></c:url>'
													class="btn btn-danger btn-circle btn-sm"> <i
														class="fas fa-trash"></i>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@include file="/WEB-INF/views/admin/footer.jsp"%>
			<!-- End of Footer -->

		</div>
		<!-- End of Page Wrapper --> --%>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->


	

<!-- Scripts -->
	<%@include file="/WEB-INF/views/admin/adminscript.jsp"%>
	<!-- End of Scripts -->
</body>

</html>