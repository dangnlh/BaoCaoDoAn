<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="item" items="${ getProject }">
			<h1>Group: ${ item.group_id }</h1>
			<h1>Project Name : ${ item.name }</h1>
			<h1>Created Time : ${ item.createTime }</h1>
	
	</c:forEach>
</body>
</html>