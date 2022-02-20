<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<title>Teacher Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<style>
.nav-tabs {
	border-bottom: 5px solid #00b3a1 !important;
}

.content h4 {
	color: #06c;
}

.content span {
	color: black;
}

.tab-content h2 {
	border-color: #00b3a1;
	background-color: #06c;
	color: white;
}
</style>
<div class="container-fluid"
	style="background-color: #00796b; color: white">
	<h2>Quan Ly Do An - FPT University HCM</h2>
</div>

<div class="container-fluid" style="margin: 5px 30px">

	<ul class="nav nav-tabs">
		<li class="active"><a
			href='<c:url value="/teacher_getProject/${ InforAccount.group_id }"/>'>Project</a>
		</li>



		<li class="active"><a
			href='<c:url value="/teacher_viewReportSchedule"/>'>Schedule
				Report</a></li>
		<li><a data-toggle="tab" href="#menu3">Menu 3</a></li>
		<li class="active"><a href='<c:url value="/teacher_viewReport"/>'>Report</a></li>
	</ul>

	<div class="tab-content">
		<div id="home" class="tab-pane fade in active">

			<c:forEach var="item" items="${ projectById }">

				<div class="content">
					<h2>Your Project :</h2>

					<h4>
						Name : <span>${ item.name }</span>
					</h4>
					<h4>
						Time Create : <span>${ item.createTime }</span>
					</h4>
					<h4>

						<a
							href='<c:url value="/teacher_getScheduleMeeting/${ item.id }"/>'>
							Schedule Meeting <span>(xem lich hop) :${ item.name }</span>
						</a>
					</h4>
				</div>


			</c:forEach>

			<c:forEach var="item" items="${ ScheduleMeetingByProjectId }">
				<div class="content">
					<h2>Your Schedule Meeting :</h2>
					<h4>
						Id : <span>${ item.id }</span>
					</h4>
					<h4>
						Name : <span>${ item.name }</span>
					</h4>
					<h4>
						Time Meeting : <span>${ item.timeMeeting }</span>
					</h4>
					<h4>
						Link Meeting :
						<button style="background-color: #777; color: white">
							<a href="${ item.link_meeting }">Meet URL</a>
						</button>
					</h4>
					<h4>
						Content : <span>${ item.content }</span>
					</h4>
				</div>

			</c:forEach>
		</div>

		<div id="menu1" class="tab-pane fade"></div>
		<c:set var="scheduleReports" value="${scheduleReports}" />
		<c:if test="${scheduleReports!=null}">
			<div id="menu2" class="tab-pane fade in active">
				<h2>Schedule Report Of Managed Group :</h2>
				<!--  
			<c:forEach var="group" items="${groupList}">
			
			<div class="content">
				
				<h4>Name : <span>${ group.name }</span></h4>	

			</div>		
			</c:forEach>
		-->
				<c:forEach var="scheduleReport" items="${scheduleReports}">
					<c:set var="report" value="${scheduleReport.report}" />
					<c:set var="group" value="${scheduleReport.group}" />
					<h4>Time Report:${scheduleReport.timeReport }</h4>
					<h4>Report Name:${report.name}</h4>
					<h4>Group Name:${group.name}</h4>
					<hr>
				</c:forEach>
			</div>
		</c:if>
		<div id="menu3" class="tab-pane fade">
			<h3>Menu 3</h3>
			<p>Eaque ipsa quae ab illo inventore veritatis et quasi
				architecto beatae vitae dicta sunt explicabo.</p>
		</div>
		<c:set var="reportList" value="${reportList}" />
		<c:if test="${reportList != null }">
			<div id="menu4" class="tab-pane fade in active">
				<table class="table table-bordered">
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
		</c:if>
	</div>
</div>
<div class="jumbotron text-center" style="margin-bottom: 0">
	<p>Footer</p>
</div>