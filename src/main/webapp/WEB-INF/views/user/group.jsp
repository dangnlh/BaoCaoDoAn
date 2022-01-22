<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Group</title>
</head>
<body>
<!-- 
  <h2>GROUP List: </h2>
  <c:if test="${not empty infoAccount}">
    <ul>
      <c:forEach var="user" items="${infoAccount}">
        <li>${user.id} - ${user.name} - ${user.address} - ${user.group_id}</li>
      </c:forEach>
    </ul>
  </c:if> -->
   <h1>Group ne</h1>
   <h1>${ groups.size() }</h1>
  <c:forEach var="item" items="${ groups }" varStatus="counter" >
  			<c:if test="${not empty item }"/>
  			<div align="center">
  			<table border="2"  cellpadding="7">
  				<thead>
  					<tr>
  						<th>.NO</th>
  						<th>ID</th>
  						<th>Name</th>
  						<th>Mail</th>
  						<th>Role</th>
  						<th>GroupID</th>
  						<th>DELETE</th>
  					</tr>
  				</thead>
  				<tbody>
  					<tr>
  						<td>${counter.index + 1 }</td>
  						<td>${ item.id }</td>
  						<td>${ item.name }</td>
  						<td>${ item.mail }</td>
  						<td>${ item.role }</td>
  						<td>${ item.group_id }</td>
  						
  						<td><a href='<c:url value="/group/${ item.group_id }/delete/${item.id}"></c:url>'>Delete</a></td>
  						
  						
  					</tr>
  				</tbody>
  			</table>
  			</div>
  </c:forEach>
  
  <h1 style="color: red">${ statusDeleme }</h1>
</body>
</html>