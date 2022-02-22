<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>MEETING</h2>

		<table class="table table-striped" border="1">


			<thead>
				<tr>
					<th>ID</th>
					<th>Meeting_id</th>
					<th>Content</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${ MeetingRecord }">
					<tr>
						<td>${ item.id }</td>
						<td>${ item.meetingId }</td>
						<td>${item.content }</td>
					
					</tr>
				</c:forEach>
			</tbody>

		</table>
		

	</div>

	
</body>
</html>