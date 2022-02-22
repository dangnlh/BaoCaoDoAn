
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="/WEB-INF/views/user/teacher/linkHeader.jsp"%>

<body>

	<div class="container-scroller" style="margin-top: -75px;">


		<%@include file="/WEB-INF/views/user/teacher/Header.jsp"%>



		<div class="container-fluid page-body-wrapper">

			  <%@include file="/WEB-INF/views/user/teacher/sidebar.jsp" %>



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
													<th>Group</th>
													<th>Created</th>
													<th>Status</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${ projectById }">
													<tr>
														<td>${ item.name }</td>
														<td>${ item.group_id }</td>
														<td>${ item.createTime }</td>
														<td><label class="badge badge-danger">Pending</label></td>
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

