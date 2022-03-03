
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="/WEB-INF/views/user/teacher/linkHeader.jsp"%>

<body>

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
								<h4 style="text-transform: uppercase;padding:16px;">Your Schedule Meeting  </h4>
									<c:forEach var="project" items="${ projects }">
									
										<c:set var="ScheduleMeeting" value="${ project.scheduleMeeting }" />
										
										<h5 style="text-align: center; text-transform: uppercase;padding:16px;">${ project.name }</h5>
										<table class="table table-striped project-orders-table">
											<thead>
												<tr>
													<th>Name Schedule</th>
													<th>Time Meeting</th>
													
													<th>Link Meeting</th>
													<th>Content</th>
													
												</tr>
											</thead>
											<tbody>
										
													<c:forEach var="item" items="${ ScheduleMeeting }">
														<tr>
															<td>${ item.name }</td>
															<td>${ item.timeMeeting }</td>
															
															<td><a  href="${item.link_meeting }">Meet URL</a> </td>
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

				<%@include file="/WEB-INF/views/user/teacher/footer.jsp"%>

			</div>



	


</body>

</html>

