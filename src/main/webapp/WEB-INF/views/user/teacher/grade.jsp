<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<%@include file="/WEB-INF/views/user/teacher/linkHeader.jsp"%>
<<<<<<< HEAD
<header>

	<style>
.error {
	font-size: 1rem;
	color: red;
}
</style>
</header>
<body>

=======
</head>
<body style="overflow: visible;">
>>>>>>> main
	<div class="header">
		<!-- -----------------HEADER-------------------- -->
		<%@include file="/WEB-INF/views/user/teacher/header.jsp"%>
		<!-- -----------------END OF HEADER-------------------- -->
		<!-- -----------------MENU BAR-------------------- -->
		<%@include file="/WEB-INF/views/user/teacher/menubar.jsp"%>
		<!-- -----------------END OF MENU BAR-------------------- -->
	</div>
<<<<<<< HEAD


=======
>>>>>>> main
	<!-- partial -->
	<div class="main-panel">
		<div class="content-wrapper">

<<<<<<< HEAD



			<div class="row">


				<div class="col-lg-12 grid-margin stretch-card">
					<div class="card">
						<div class="card-body">
							<h1 style="text-align: center;">GRADE FOR REPORT</h1>
							<c:set value="${report}" var="report" />
							<c:set value="${student}" var="student" />
							<h5>Report Name: ${report.name}</h5>
							<h5>Student Name:${student.name }</h5>
							<c:if test="${editAction == null }">
								<form:form
									action="${pageContext.request.contextPath}/processGrade"
									method="POST" modelAttribute="pointDetail">
									<form:hidden path="id" />
									<form:hidden path="reportId" />
									<form:hidden path="studentId" />
									<form:hidden path="teacherId" />
									<br>
									<form:input path="point" />
									<form:errors path="point" cssClass="error" />
									<br>
									<br>
									<input type="submit" />
								</form:form>
							</c:if>
							<c:if test="${editAction == true }">
								<form:form
									action="${pageContext.request.contextPath}/processEditGrade"
									method="POST" modelAttribute="pointDetail">
									<form:hidden path="id" />
									<form:hidden path="reportId" />
									<form:hidden path="studentId" />
									<form:hidden path="teacherId" />
									<br>
									<form:input path="point" />
									<form:errors path="point" cssClass="error" />
									<br>
									<br>
									<input type="submit" />
								</form:form>
							</c:if>
=======
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
>>>>>>> main
						</div>
					</div>
				</div>

			</div>

		</div>

		<%@include file="/WEB-INF/views/user/teacher/footer.jsp"%>

	</div>

<<<<<<< HEAD

=======
>>>>>>> main

</body>

</html>

