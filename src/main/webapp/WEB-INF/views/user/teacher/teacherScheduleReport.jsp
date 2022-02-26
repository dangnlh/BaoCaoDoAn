
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="/WEB-INF/views/user/teacher/linkHeader.jsp"%>

<body>

	<div class="container-scroller" style="margin-top: -75px;">


		<%@include file="/WEB-INF/views/user/teacher/Header.jsp"%>



		<div class="container-fluid page-body-wrapper">

			<%@include file="/WEB-INF/views/user/teacher/sidebar.jsp"%>


			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">




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
											
												<th>Group Name</th>
											
											</tr>
										</thead>
										<tbody>
											<c:forEach var="scheduleReport" items="${scheduleReports}">
											<tr> 
												<c:set var="report" value="${scheduleReport.report}" />
												<c:set var="group" value="${scheduleReport.group}" />
													<td>${report.name}</td>
												<td>${scheduleReport.timeReport }</td>
											
												<td>${group.name}</td>
											
												</tr>
											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>

						</div>

					</div>

				</div>

				<%@include file="/WEB-INF/views/user/teacher/Footer.jsp"%>

			</div>

		</div>

	</div>


</body>

</html>

