
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


									<div class="table table-striped project-orders-table">
								<h4 style="text-transform: uppercase;padding:16px;">Your Group  </h4>


										<c:forEach var="group" items="${studentGroup}">
											<c:set var="account" value="${group.account}" />
											<h5 style="text-align: center; text-transform: uppercase;margin:16px;">${group.name}</h5>
											<table class="table">
												<thead>

													<tr>
														
														<th>ID</th>
														<th>Name</th>
														<th>Mail</th>
														<th>Role</th>
														<th>GroupID</th>
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
													</tr>
												</tbody>
												</c:forEach>
											</table>
										</c:forEach>

									</div>
								</div>

							</div>
							
								=
						</div>

					</div>

				</div>

				<%@include file="/WEB-INF/views/user/teacher/Footer.jsp"%>

			</div>

		</div>

	</div>


</body>

</html>

