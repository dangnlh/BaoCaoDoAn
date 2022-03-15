
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="/WEB-INF/views/user/teacher/linkHeader.jsp"%>

<body style="overflow: visible;">

	<div class="header">
		<!-- -----------------HEADER-------------------- -->
		<%@include file="/WEB-INF/views/user/teacher/header.jsp"%>
		<!-- -----------------END OF HEADER-------------------- -->
		<!-- -----------------MENU BAR-------------------- -->
		<%@include file="/WEB-INF/views/user/teacher/menubar.jsp"%>
		<!-- -----------------END OF MENU BAR-------------------- -->
	</div>


			<div class="main-panel">
				<div class="content-wrapper">




							<div class="row">


						<div class="col-lg-12 grid-margin stretch-card">
							<div class="card">
								<div class="table-responsive pt-3">
								<h4 style="text-transform: uppercase;padding:16px;">Your Project </h4>
									<table class="table table-striped project-orders-table">
										<thead>
											<tr>
												<th>Project</th>
												<th>Group</th>
												<th>Created</th>
												<th>Url Project</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${ projectById }">
												<tr>
													<td>${ item.name }</td>
													<td>${ item.group_id }</td>
													<td>${ item.createTime }</td>
													<td>${ item.urlProject }</td>
												</tr>
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

