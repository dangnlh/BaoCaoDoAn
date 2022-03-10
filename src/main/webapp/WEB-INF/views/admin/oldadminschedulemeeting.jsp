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
<title>Schedule Meeting Page</title>
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
						<h1 class="h3 mb-0 text-gray-800">Schedule Meeting</h1>

					</div>






					<div class="container">
						<h2>Schedule Meeting</h2>

						<table class="table table-striped" border="1">


							<thead>
								<tr>
									<th>Id</th>
									<th>TimeMeeting</th>
									<th>Project_id</th>
									<th>Account_id</th>
									<th>Name ScheduleMeeting</th>
									<th>Link Meeting</th>
									<th>Content</th>
									<th>Date Submit</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${ ScheduleMeeting }">
									<tr>
										<td>${ item.id }</td>
										<td>${ item.timeMeeting }</td>
										<td>${ item.project_id }</td>
										<td>${ item.account_id }</td>
										<td>${ item.name }</td>
										<td>${ item.link_meeting }</td>
										<td>${ item.content  }</td>
										<td>${ item.submitDate }</td>

										<td><a class="btn btn-success"
											href='<c:url value="/editScheduleMeeting?id=${ item.id }"></c:url>'>Edit</a>






											<a
											href='<c:url value="/deleteScheduleMeeting?id=${ item.id }"/>'
											class="btn btn-danger">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
						<a class="btn btn-primary" data-toggle="modal"
							data-target="#myModal2" href="addScheduleMeeting">Add
							ScheduleMeeting</a>


						<div class="modal" id="myModal2">
							<div class="modal-dialog">
								<div class="modal-content">


									<div class="modal-header">
										<h4 class="modal-title">Add New ScheduleMeeting</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>


									<div class="modal-body">
										<form:form method="POST" action="addScheduleMeeting"
											modelAttribute="ScheduleMeeting2">

											<label for="email2" class="mb-2 mr-sm-2">Name Report</label>
											<br>
											<form:input path="name" type="text"
												class="form-control mb-2 mr-sm-2" placeholder="Name Report" />
											<br>
											<br>



											<label for="pwd2" class="mb-2 mr-sm-2">Time Submit</label>
											<br>
											<form:input path="timeSubmit" type="date"
												class="form-control mb-2 mr-sm-2" value="2022-06-01" />
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

					<div class="row"></div>

					<div class="col-lg-6 mb-4">
						<!-- DataTales Example -->
						<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">Schedule
									Meeting</h6>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-bordered" id="dataTable" width="100%"
										cellspacing="0">
										<thead>
											<tr>
												<th>1</th>
												<th>2</th>
												<th>3</th>
												<th>4</th>
												<th>5</th>
												<th>Action</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th>1</th>
												<th>2</th>
												<th>3</th>
												<th>4</th>
												<th>5</th>
												<th>Action</th>
											</tr>
										</tfoot>
										<tbody>
											<c:forEach var="items" items="${ group4 }"
												varStatus="counter">
												<c:if test="${not empty items }" />
												<tr>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td><a href=''
														class="btn btn-success btn-circle btn-sm"> <i
															class="fas fa-check"></i>
													</a> <a href='' class="btn btn-danger btn-circle btn-sm"> <i
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
			<!-- End of Content Wrapper -->
		</div>
		<!-- End of Page Wrapper -->

		<!-- Scripts -->
		<%@include file="/WEB-INF/views/admin/adminscript.jsp"%>
		<!-- End of Scripts -->
</body>

</html>