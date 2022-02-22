
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
								<div class="card-body">


									<div class="table-responsive">

										<table class="table">
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
												<c:if
													test="${teacherGetScheduleMeetingByProjectId != null }">
													<c:forEach var="item"
														items="${ teacherGetScheduleMeetingByProjectId }">
														<tr>
															<td>${ item.name_project }</td>
															<td>${ item.timeMeeting }</td>
															<td>${ item.name_scheduleMeeting }</td>
															<td><a href="${ item.link_meeting }">Meet URl</a></td>
															<td>${ item.content_scheduleMeeting }</td>
														</tr>
													</c:forEach>
												</c:if>
											</tbody>

										</table>

									</div>
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

