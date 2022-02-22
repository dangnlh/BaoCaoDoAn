
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
								<div class="card-body">


									<div class="table-responsive">

										<table class="table">
											<thead>
												<tr>
													<th>Report Name</th>

													<th>Time Submit</th>
													<th>Download</th>
													<th>Point</th>
													<th>Group Name</th>
													<th>Status</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="report" items="${reportList}">
													<tr>
														<td>${report.name }</td>

														<td>${report.timeSubmit}</td>
														<td><a>Download Report</a></td>
														<th>${report.point}</th>
														<td>Group Name</td>
														<td>${report.convertedStatus}</td>
														<td>
															<!--khi da summit thi doi background khac  --> <c:if
																test="${report.status > 0}">

																<button>
																	<a href='<c:url value="/teacher_grade/${report.id}"/>'>Grade</a>
																</button>
															</c:if> <!--khi chua summit thi doi background khac  --> <c:if
																test="${report.status < 1}">
																<button disabled="disabled">
																	<a href="">Grade</a>
																</button>
															</c:if>
														</td>
													</tr>
												</c:forEach>
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

