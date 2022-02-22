<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
									<h1 style="text-align: center;">GRADE FOR REPORT</h1>
									<form:form
										action="${pageContext.request.contextPath}/processGrade"
										method="POST" modelAttribute="report">
										<form:hidden path="id" />
										<form:input path="name" readonly="true" />
										<br>
										<form:input path="timeSubmit" readonly="true" />
										<br>
										<form:input path="point" />
										<form:errors path="point" cssClass="error" />
										<br>
										<a href="#">Download</a>
										<br>
										<input type="submit" />
									</form:form>
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

