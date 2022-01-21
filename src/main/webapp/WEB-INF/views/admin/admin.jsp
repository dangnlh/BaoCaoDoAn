<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<c:if test="${ not empty inforAccount }">
		<div align="center">
			<h1>Admin Page</h1>
			<table border="1">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Mail</th>
						<th>Role</th>
						<th>Group_ID</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${ inforAccount.id }</td>
						<td>${ inforAccount.name }</td>
						<td>${ inforAccount.mail }</td>
						<td>${ inforAccount.role }</td>
						<td>${ inforAccount.group_id }</td>
					</tr>
				</tbody>
			</table>
		</div>

	</c:if>


	<div align="center">
		<h4>
			<a href='<c:url value="/addAdmin"></c:url>'>Add Meeting</a>
		</h4>
		<table border="1" cellpadding="7">
			<tr>
				<th>.NO</th>

				<th>TimeMeeting</th>
				<th>Project_ID</th>
				<th>Account_ID</th>
			</tr>
			<c:forEach var="item" items="${ admin }" varStatus="counter">
				<tr>
					<td>${counter.index + 1 }</td>

					<td>${ item.timeMeeting }</td>
					<td>${ item.project_id }</td>
					<td>${ item.account_id }</td>
					<td><a href="edit?id=${item.id}">EDIT</a></td>
					<td><a href="deleteAdmin?id=${item.id}">DELETE</a></td>
				</tr>
			</c:forEach>
		</table>

		<h1>${status }</h1>

	</div>


</body>
</html>