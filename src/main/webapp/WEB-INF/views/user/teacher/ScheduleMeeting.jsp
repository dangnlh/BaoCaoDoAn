
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="/WEB-INF/views/user/teacher/linkHeader.jsp"%>

<body>

	<div class="container-scroller" style="margin-top: -75px;">


		<%@include file="/WEB-INF/views/user/teacher/Header.jsp"%>



		<div class="container-fluid page-body-wrapper">

			  <%@include file="/WEB-INF/views/user/teacher/sidebar.jsp" %>


			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">




					<div class="row">


						<div class="col-lg-12 grid-margin stretch-card">
							<div class="card">
							
								<div class="table-responsive pt-3">
									<c:forEach var="project" items="${ projects }">
										<c:set var="ScheduleMeeting" value="${ project.scheduleMeeting }" />
										<h2 style="text-align: center;text-transform: uppercase;padding:16px;">${ project.name }</h2>
										<table class="table table-striped project-orders-table">
											<thead>
												<tr>
													<th>Project</th>
													<th>Time Meeting</th>
													<th>Name Schedule</th>
													<th>Link Meeting</th>
													<th>Content</th>
													
												</tr>
											</thead>
											<tbody>
										
													<c:forEach var="item" items="${ ScheduleMeeting }">
														<tr>
															<td>${ item.name }</td>
															<td>${ item.timeMeeting }</td>
															<td>${ item.project_id }</td>
															<td>${item.link_meeting }</td>
															<td>${item.content }</td>
														</tr>
													</c:forEach>
										

											</tbody>
										</table>
									</c:forEach>
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

