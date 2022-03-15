<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<%@include file="/WEB-INF/views/user/teacher/linkHeader.jsp"%>
</head>
<body style="overflow: visible;">
	<div class="header">
		<!-- -----------------HEADER-------------------- -->
		<%@include file="/WEB-INF/views/user/teacher/header.jsp"%>
		<!-- -----------------END OF HEADER-------------------- -->
		<!-- -----------------MENU BAR-------------------- -->
		<%@include file="/WEB-INF/views/user/teacher/menubar.jsp"%>
		<!-- -----------------END OF MENU BAR-------------------- -->
	</div>
	<!-- partial -->
	<div class="main-panel">
		<div class="content-wrapper">

			<div class="row">

				<div class="col-lg-12 grid-margin stretch-card">
					<div class="card">
						<div class="table-responsive pt-3">
							<h4 style="text-transform: uppercase; padding: 16px;">GRADE
								FOR REPORT</h4>
								<h6 style="text-transform: uppercase; padding: 16px;">Chỗ này để tên Report</h6>
								<h6 style="text-transform: uppercase; padding: 16px;">Chỗ này để ngày nộp</h6>
							<table class="table table-striped project-orders-table">
								<thead>
									<tr>
										<th>ID</th>
										<th>Name</th>
										<th>Mail</th>
										<th>Role</th>
										<th>GroupID</th>
										<th>Grade</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${account}">
										<tr>
											<td>${ item.id }</td>
											<td>${ item.name }</td>
											<td>${ item.mail }</td>
											<td>${ item.role }</td>
											<td>${ item.group_id }</td>
											<td>$</td>
										</tr>
								</tbody>
								</c:forEach>

								</tbody>
							</table>
						</div>
					</div>

				</div>

			</div>

		</div>

		<%@include file="/WEB-INF/views/user/teacher/footer.jsp"%>

	</div>


</body>

</html>

